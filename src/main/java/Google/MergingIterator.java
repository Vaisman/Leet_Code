package Google;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

class MergingIterator implements Iterator<Integer> {
    PriorityQueue<PeekingIterator> pq;

    public MergingIterator(List<Iterator<Integer>> iterators) {
        pq = new PriorityQueue<>((a,b) -> a.peek()-b.peek());
        for(Iterator<Integer> itr : iterators){
            pq.add(new PeekingIterator(itr));
        }
    }

    public boolean hasNext() {
        return !pq.isEmpty();
    }

    public Integer next() {
        PeekingIterator curr = pq.poll();
        Integer val = curr.hasNext() ? curr.next() : null;
        return val;
    }
}

class PeekingIterator implements Iterator<Integer> {
    Integer next = null;
    Iterator<Integer> curr;
    boolean done = false;
    public PeekingIterator(Iterator<Integer> iterator) {
        curr = iterator;
        moveIterator();
    }

    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        if(done){
            throw new NoSuchElementException();
        }
        Integer res = next;
        moveIterator();

        return res;
    }

    @Override
    public boolean hasNext() {
        return next!=null;
    }

    public void moveIterator(){
        if(curr.hasNext()){
            next = curr.next();
        }
        else{
            done = true;
            next = null;
        }
    }
}
