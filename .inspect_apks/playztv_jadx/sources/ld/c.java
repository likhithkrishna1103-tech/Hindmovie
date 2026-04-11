package ld;

import c6.l;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f8125a;

    public c(int i) {
        switch (i) {
            case 1:
                this.f8125a = new ArrayList();
                break;
            default:
                File file = new File(System.getProperty("java.io.tmpdir"));
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.f8125a = new ArrayList();
                break;
        }
    }

    public void a() {
        ArrayList arrayList = this.f8125a;
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
            } catch (Exception e10) {
                k.f8153d.log(Level.WARNING, "could not delete file ", (Throwable) e10);
            }
        }
        arrayList.clear();
    }

    public synchronized l b(Class cls) {
        int size = this.f8125a.size();
        for (int i = 0; i < size; i++) {
            s6.d dVar = (s6.d) this.f8125a.get(i);
            if (dVar.f11872a.isAssignableFrom(cls)) {
                return dVar.f11873b;
            }
        }
        return null;
    }
}
