package base.extra;

public interface Callback<T> {
  void onComplete(T object);

  void onException(Exception e);
}
