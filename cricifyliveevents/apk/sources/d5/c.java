package d5;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import ge.i;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3393b;

    public /* synthetic */ c(int i, int i10) {
        this.f3392a = i10;
        this.f3393b = i;
    }

    public static void a(String str) {
        if (str.equalsIgnoreCase(":memory:")) {
            return;
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z10 = false;
        while (i <= length) {
            boolean z11 = i.f(str.charAt(!z10 ? i : length), 32) <= 0;
            if (z10) {
                if (!z11) {
                    break;
                } else {
                    length--;
                }
            } else if (z11) {
                i++;
            } else {
                z10 = true;
            }
        }
        if (str.subSequence(i, length + 1).toString().length() == 0) {
            return;
        }
        Log.w("SupportSQLite", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e9) {
            Log.w("SupportSQLite", "delete failed: ", e9);
        }
    }

    public static String b(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    public abstract int c();

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract void i(e5.c cVar);

    public abstract void j(e5.c cVar, int i, int i10);

    public abstract void k(e5.c cVar);

    public abstract void l(e5.c cVar, int i, int i10);

    public String toString() {
        switch (this.f3392a) {
            case 2:
                return b(this.f3393b);
            default:
                return super.toString();
        }
    }

    public void h(e5.c cVar) {
    }
}
