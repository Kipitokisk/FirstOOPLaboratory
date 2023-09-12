public class Book {
    private String title;
    private String author;
    private int totalNrOfPages;
    private int currentPage;

    public Book(String title, String author, int totalNrOfPages, int currentPage) {
        this.title = title;
        this.author = author;
        this.totalNrOfPages = totalNrOfPages;
        this.currentPage = currentPage;
    }

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
