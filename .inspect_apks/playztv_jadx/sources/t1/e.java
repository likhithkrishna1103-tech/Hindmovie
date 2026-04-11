package t1;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12004b;

    public /* synthetic */ e(int i, int i10) {
        this.f12003a = i10;
        this.f12004b = i;
    }

    public static void a(String str) {
        if (str.equalsIgnoreCase(":memory:")) {
            return;
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z10 = be.h.f(str.charAt(!z2 ? i : length), 32) <= 0;
            if (z2) {
                if (!z10) {
                    break;
                } else {
                    length--;
                }
            } else if (z10) {
                i++;
            } else {
                z2 = true;
            }
        }
        if (str.subSequence(i, length + 1).toString().length() == 0) {
            return;
        }
        Log.w("SupportSQLite", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e10) {
            Log.w("SupportSQLite", "delete failed: ", e10);
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

    public abstract void i(a5.d dVar);

    public abstract void j(a5.d dVar, int i, int i10);

    public abstract void k(a5.d dVar);

    public abstract void l(a5.d dVar, int i, int i10);

    public String toString() {
        switch (this.f12003a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return b(this.f12004b);
            default:
                return super.toString();
        }
    }

    public void h(a5.d dVar) {
    }
}
