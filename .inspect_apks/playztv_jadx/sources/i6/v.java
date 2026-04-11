package i6;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v implements com.bumptech.glide.load.data.e, com.bumptech.glide.load.data.d {
    public boolean A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f6426u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p0.c f6427v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6428w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.bumptech.glide.f f6429x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.bumptech.glide.load.data.d f6430y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List f6431z;

    public v(ArrayList arrayList, p0.c cVar) {
        this.f6427v = cVar;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f6426u = arrayList;
        this.f6428w = 0;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return ((com.bumptech.glide.load.data.e) this.f6426u.get(0)).a();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        List list = this.f6431z;
        if (list != null) {
            this.f6427v.b(list);
        }
        this.f6431z = null;
        ArrayList arrayList = this.f6426u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((com.bumptech.glide.load.data.e) obj).b();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final int c() {
        return ((com.bumptech.glide.load.data.e) this.f6426u.get(0)).c();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.A = true;
        ArrayList arrayList = this.f6426u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((com.bumptech.glide.load.data.e) obj).cancel();
        }
    }

    public final void d() {
        if (this.A) {
            return;
        }
        if (this.f6428w < this.f6426u.size() - 1) {
            this.f6428w++;
            e(this.f6429x, this.f6430y);
        } else {
            x6.f.b(this.f6431z);
            this.f6430y.l(new e6.x("Fetch failed", new ArrayList(this.f6431z)));
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(com.bumptech.glide.f fVar, com.bumptech.glide.load.data.d dVar) {
        this.f6429x = fVar;
        this.f6430y = dVar;
        this.f6431z = (List) this.f6427v.i();
        ((com.bumptech.glide.load.data.e) this.f6426u.get(this.f6428w)).e(fVar, this);
        if (this.A) {
            cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void l(Exception exc) {
        List list = this.f6431z;
        x6.f.c(list, "Argument must not be null");
        list.add(exc);
        d();
    }

    @Override // com.bumptech.glide.load.data.d
    public final void r(Object obj) {
        if (obj != null) {
            this.f6430y.r(obj);
        } else {
            d();
        }
    }
}
