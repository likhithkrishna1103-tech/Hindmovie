package k5;

import android.database.DataSetObservable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataSetObservable f7017a = new DataSetObservable();

    public abstract void a(Object obj);

    public abstract void b();

    public abstract int c();

    public final void d() {
        synchronized (this) {
        }
    }

    public abstract void e(i iVar);
}
