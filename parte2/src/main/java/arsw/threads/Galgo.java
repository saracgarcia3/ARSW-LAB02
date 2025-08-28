package arsw.threads;

/**
 * Un galgo que puede correr en un carril
 *
 * @author rlopez
 */
public class Galgo extends Thread {
	private int paso;
	private Carril carril;
	private RegistroLlegada regl;

	// 🔑 Variables para pausa/reanudar
	private final Object pauseLock;
	private boolean paused = false;

	public Galgo(Carril carril, String name, RegistroLlegada reg, Object pauseLock) {
		super(name);
		this.carril = carril;
		paso = 0;
		this.regl = reg;
		this.pauseLock = pauseLock;
	}

	public void setPaused(boolean paused) {
		synchronized (pauseLock) {
			this.paused = paused;
			if (!paused) {
				pauseLock.notifyAll(); // despertar a todos cuando se reanude
			}
		}
	}

	public void corra() throws InterruptedException {
		while (paso < carril.size()) {

			// 🔒 Sección para pausa
			synchronized (pauseLock) {
				while (paused) {
					pauseLock.wait();
				}
			}

			Thread.sleep(100);
			carril.setPasoOn(paso++);
			carril.displayPasos(paso);

			if (paso == carril.size()) {
				carril.finish();
				int ubicacion = regl.getAndIncrementarPosicion();
				System.out.println("El galgo " + this.getName() + " llegó en la posición " + ubicacion);
				if (ubicacion == 1) {
					regl.setGanador(this.getName());
				}
			}
		}
	}

	@Override
	public void run() {
		try {
			corra();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
