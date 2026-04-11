package i6;

import android.graphics.Matrix;
import android.graphics.Path;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6231a;

    public c(int i) {
        switch (i) {
            case 1:
                this.f6231a = new ArrayList();
                break;
            case 2:
                File file = new File(System.getProperty("java.io.tmpdir"));
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.f6231a = new ArrayList();
                break;
            default:
                this.f6231a = new ArrayList();
                break;
        }
    }

    public void a(Path path) {
        ArrayList arrayList = this.f6231a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            u uVar = (u) arrayList.get(size);
            Matrix matrix = s6.i.f11583a;
            if (uVar != null && !uVar.f6339a) {
                s6.i.a(path, uVar.f6342d.l() / 100.0f, uVar.f6343e.l() / 100.0f, uVar.f.l() / 360.0f);
            }
        }
    }

    public void b() {
        ArrayList arrayList = this.f6231a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (obj != null) {
                throw new ClassCastException();
            }
            try {
                throw null;
            } catch (Exception e9) {
                pd.i.f10211d.log(Level.WARNING, "could not delete file ", (Throwable) e9);
            }
        }
        arrayList.clear();
    }
}
