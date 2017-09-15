
public interface Singleton<T extends Singleton<T>> {
	T getInstance(); // java complains twelve different ways if I declare this static even though it really should be
}
