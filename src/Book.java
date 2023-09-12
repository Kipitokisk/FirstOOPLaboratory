public class Book {
    private String title;
    private String author;
    private int totalNrOfPages;
    private int currentPage;

    public void nextPage(){
        if (currentPage + 1 <= totalNrOfPages && currentPage >= 0){
            currentPage += 1;
        } else {
            System.out.println("No more pages.");
        }
    }

    public void goToPage(int nr){
        if (nr >= 0 && nr <= totalNrOfPages){
            currentPage = nr;
        }
    }

    public void pageNumberDisplay(){
        System.out.println("Current page is " + currentPage);
    }

}
