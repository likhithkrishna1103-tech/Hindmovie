package d7;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements com.bumptech.glide.load.data.d, com.bumptech.glide.load.data.c {
    public List A;
    public boolean B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f3514v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final s0.c f3515w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3516x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.bumptech.glide.h f3517y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public com.bumptech.glide.load.data.c f3518z;

    public y(ArrayList arrayList, s0.c cVar) {
        this.f3515w = cVar;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f3514v = arrayList;
        this.f3516x = 0;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        return ((com.bumptech.glide.load.data.d) this.f3514v.get(0)).a();
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        List list = this.A;
        if (list != null) {
            this.f3515w.b(list);
        }
        this.A = null;
        ArrayList arrayList = this.f3514v;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((com.bumptech.glide.load.data.d) obj).b();
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public final void c(Exception exc) {
        List list = this.A;
        s7.f.c(list, "Argument must not be null");
        list.add(exc);
        g();
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        this.B = true;
        ArrayList arrayList = this.f3514v;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((com.bumptech.glide.load.data.d) obj).cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public final void d(Object obj) {
        if (obj != null) {
            this.f3518z.d(obj);
        } else {
            g();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final int e() {
        return ((com.bumptech.glide.load.data.d) this.f3514v.get(0)).e();
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(com.bumptech.glide.h hVar, com.bumptech.glide.load.data.c cVar) {
        this.f3517y = hVar;
        this.f3518z = cVar;
        this.A = (List) this.f3515w.i();
        ((com.bumptech.glide.load.data.d) this.f3514v.get(this.f3516x)).f(hVar, this);
        if (this.B) {
            cancel();
        }
    }

    public final void g() {
        if (this.B) {
            return;
        }
        if (this.f3516x < this.f3514v.size() - 1) {
            this.f3516x++;
            f(this.f3517y, this.f3518z);
        } else {
            s7.f.b(this.A);
            this.f3518z.c(new z6.x("Fetch failed", new ArrayList(this.A)));
        }
    }
}
