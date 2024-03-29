package persistencejs;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import adapter.ProdutoAdapter;
import entity.Produto;

public class ProdutoDao extends Dao {

	public static final String PRODUTO = "produto";

	public void save(Produto p) throws Exception {
		try {
			MongoCollection<Document> coll = getDb().getCollection(PRODUTO);
			coll.insertOne(ProdutoAdapter.toDocument(p));

		} finally {
			close();
		}

	}

	public List<Produto> findAll() throws Exception {
		MongoCursor<Document> doc = null;

		List<Produto> lista = null;
		try {
			MongoCollection<Document> collection = getDb().getCollection(PRODUTO);
			doc = collection.find().iterator();
			lista = new ArrayList<>();
			while (doc.hasNext()) {
				lista.add(ProdutoAdapter.toProduto(doc.next()));
			}
			doc.close();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static void main(String[] args) {
		try {
			new ProdutoDao().findAll().stream().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
