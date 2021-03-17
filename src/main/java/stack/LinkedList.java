package stack;

import exception.EmptyListException;

public class LinkedList<T> implements List<T>
{
  private Node<T> head;
  private int size;

  @Override public boolean isEmpty()
  {
    return head == null;
  }

  @Override public int size()
  {
    size = 0;

    //Check if the list is empty
    if (!isEmpty())
    {

      //Create a pointer and point it at the start
      Node<T> p = head;

      //Loop until the next node after pointer is null
      while (p.getNext() != null)
      {
        //Moving the pointer to the next node and repeating the process until condition is met
        p = p.getNext();

        size++;
      }
    }
    return size;
  }

  @Override public void addToFront(T data)
  {

    //Creating a new Node with data provided in the argument
    Node tmpNode = new Node(data);

    //Pointing the new Node to the head
    tmpNode.setNext(head);

    //Shifting the head to the left to point to the Node added to the front
    head = tmpNode;

  }

  //The idea here is to return the first Node data and remove the Node from the list
  @Override public T removeFirst() throws EmptyListException
  {
    if (isEmpty())
    {
      throw new EmptyListException();
    }
    else
    {
      //Creating the pointer that points to the head
      Node<T> p = head;

      //Moving the head to the next Node
      head = p.getNext();

      //Clearing the link just in case
      p.setNext(null);

      return p.getData();
    }
  }
}
