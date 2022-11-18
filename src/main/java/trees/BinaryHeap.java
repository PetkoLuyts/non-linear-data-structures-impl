package trees;

public class BinaryHeap {
    private int arr[];
    private int sizeOfTree;

    public BinaryHeap(int size) {
        arr = new int[size + 1];
        sizeOfTree = 0;
        System.out.println("Binary Heap has been created");
    }

    public boolean isEmpty() {
        if (sizeOfTree == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("The binary heap is empty!");
            return null;
        }

        return arr[1];
    }

    public int sizeOfBinaryHeap() {
        return sizeOfTree;
    }

    public void levelOrder() {
        for (int i = 1; i <= sizeOfTree; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2;

        if (index <= 1) {
            return;
        }

        if (heapType.equals("Min")) {
            if (arr[index] < arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        } else if (heapType.equals("Max")) {
            if (arr[index] > arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        }

        heapifyBottomToTop(parent, heapType);
    }

    public void insert(int value, String heapType) {
        arr[sizeOfTree + 1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, heapType);

        System.out.println("Inserted " + value + " successfully in Heap");
    }
}
