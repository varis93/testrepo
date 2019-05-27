public class PolygonDemo
{
    private static class Point
    {
        public int x;
        public int y;

        public Point(int xValue, int yValue)
        {
            this.x = xValue;
            this.y = yValue;
        };
    };

    private static class Vertex
    {
        public Vertex next;
        public Point coordinates;

        public String toString()
        {
            String contents = "(" + this.coordinates.x + ", " + this.coordinates.y + ")";
            return contents;
        }
    };

    private static class Polygon
    {
        private Vertex head;

        public Polygon()
        {
            head = null;
        };

        protected void add(Point point)
        {
            if (head == null)
            {
                head = new Vertex();
                head.coordinates = point;
                head.next = null;
            }
            else
            {
                Vertex newVertex = new Vertex();
                newVertex.coordinates = point;
                Vertex current = head;
                while (current.next != null)
                {
                    current = current.next;
                }

                current.next = newVertex;
            }
        };

        protected void delete(int index)
        {   
            Vertex current = head;
            Vertex previous = null;
            int iterator = 0;

            while (current != null)
            {
                if (iterator == index)
                {
                    if (previous != null)
                    {
                        previous.next = current.next;
                    }
                    else
                    {
                        head = head.next;
                    }
                }
                previous = current;
                current = current.next;                
            }
        };

        protected String getVertex(int index)
        {
            Vertex current = head;
            int iterator = 0;

            while (current != null)
            {
                if (iterator == index)
                {
                    return current.toString();
                }
                iterator++;
                current = current.next;
            }

            throw new IndexOutOfBoundsException();
        };

        public String toString()
        {
            if (head == null)
            {
                return "Empty polygon";
            }
            else
            {
                Vertex current = head;
                String contents = "";

                while (current != null)
                {
                    contents += current.toString();
                    current = current.next;
                }

                return contents;
            }
        };
    };
    
    public static void main(String []args)
    {
        Polygon polygon = new Polygon();
        System.out.println("Empty: " + polygon);
        
        polygon.add(new Point(1, 2));
        polygon.add(new Point(3, 10));
        polygon.add(new Point(5, 4));
        System.out.println("Triangle: " + polygon);
        
        polygon.delete(0);
        System.out.println("Segment: " + polygon);
        
        System.out.println("First vertex: " + polygon.getVertex(0));
        
        System.out.println("Get missing vertex");
        polygon.getVertex(5);
     }
}