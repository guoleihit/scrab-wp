/**
 * 
 */
package wp.job;

import static utils.JSoupUtils.getElementValue;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import utils.DateUtils;
import utils.JSoupUtils.ConnectionFactory;
import wp.entity.Post;

/**
 * @author E-mail: guoleihit@gmail.com
 * @version ：2017年2月2日 下午3:18:50
 */
public class WPScrabber {

    public List<Post> fetchSimplePostList(String url) throws IOException{
        Connection con = ConnectionFactory.getConnection(url,false);
        Document doc = con.get();
        Iterator<Element> iter = doc.select("article").iterator();
        List<Post> posts = new LinkedList<Post>();
        for(;iter.hasNext();){
            Element article = iter.next();
            Post p = new Post();
            Element header = article.select("header").first();
            p.setUrl(header.select("a").attr("href"));
            p.setTitle(header.text());
            p.setAbstractMessage(getElementValue(article,"div.entry-content"));
            String dateStr = getElementValue(article,"time.entry-date");
            p.setPostDate(DateUtils.parseDate(dateStr,"yyyy年MM月dd日"));
            posts.add(p);
        }
        return posts;
    }
    public static void main(String[] args) throws IOException {
        WPScrabber sc = new WPScrabber();
        for(Post post:sc.fetchSimplePostList("https://leiguo.me")){
            System.out.println(post);
        }
    }
}
