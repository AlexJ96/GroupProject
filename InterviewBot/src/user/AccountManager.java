package user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AccountManager {
	
	private static final String path = "../data/accounts/";
	
	public synchronized static final boolean containsAccount(String accountName) {
		return new File(path + accountName + ".acc").exists();
	}
	
	public synchronized static Account loadAccount(String accountName) {
		try {
			return (Account) loadAccountFile(new File(path + accountName + ".acc"));
		} catch (Throwable e) {
			//
		}
		return null;
	}

	public synchronized static void savePlayer(Account account) {
		try {
			storeAccount(account, new File(path + account.getUsername()
					+ ".acc"));
		} catch (Throwable e) {
		}
	}

	public static final Object loadAccountFile(File f) throws IOException,
			ClassNotFoundException {
		if (!f.exists())
			return null;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		Object object = in.readObject();
		in.close();
		return object;
	}

	public static final void storeAccount(Serializable o, File f)
			throws IOException {

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(o);
		out.close();
	}
}
