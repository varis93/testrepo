public static class MyList
{
    protected static class Node
    {
        public Node Next;
        public int Value;
    };

    private Node head;
    public int count;

    public MyList()
    {
        head = null;
        count = 0;
    };

    protected void add(int value)
    {
        Node newNode = new Node();
        newNode.Value = value;
        Node current = head;

        if (head == null)
        {
            head = newNode;
            return;
        }
            current.Next = newNode;
            current = newNode;

            count++;
    };

    protected int get(int index)
    {
        Node current = head;
        int iterator = 0;

        while (current != null)
        {
            if (iterator == index)
            {
                return current.Value;
            }
            iterator++;
            current = current.Next;
        }

        throw new IndexOutOfBoundsException();

    };
};
