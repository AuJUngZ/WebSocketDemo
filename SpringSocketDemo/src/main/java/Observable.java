public interface Observable<E> { //producer
    void subscribe(Observer<E> observer);
}