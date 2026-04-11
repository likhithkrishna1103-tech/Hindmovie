package e6;

import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements g, com.bumptech.glide.load.data.d {
    public int A;
    public volatile i6.q B;
    public File C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List f4482u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f4483v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f f4484w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4485x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public c6.f f4486y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List f4487z;

    public d(List list, h hVar, f fVar) {
        this.f4482u = list;
        this.f4483v = hVar;
        this.f4484w = fVar;
    }

    @Override // e6.g
    public final boolean a() {
        while (true) {
            List list = this.f4487z;
            boolean z2 = false;
            if (list != null && this.A < list.size()) {
                this.B = null;
                while (!z2 && this.A < this.f4487z.size()) {
                    List list2 = this.f4487z;
                    int i = this.A;
                    this.A = i + 1;
                    i6.r rVar = (i6.r) list2.get(i);
                    File file = this.C;
                    h hVar = this.f4483v;
                    this.B = rVar.a(file, hVar.f4510e, hVar.f, hVar.i);
                    if (this.B != null && this.f4483v.c(this.B.f6422c.a()) != null) {
                        this.B.f6422c.e(this.f4483v.f4518o, this);
                        z2 = true;
                    }
                }
                return z2;
            }
            int i10 = this.f4485x + 1;
            this.f4485x = i10;
            if (i10 >= this.f4482u.size()) {
                return false;
            }
            c6.f fVar = (c6.f) this.f4482u.get(this.f4485x);
            h hVar2 = this.f4483v;
            File fileF = hVar2.f4512h.a().f(new e(fVar, hVar2.f4517n));
            this.C = fileF;
            if (fileF != null) {
                this.f4486y = fVar;
                this.f4487z = this.f4483v.f4508c.b().g(fileF);
                this.A = 0;
            }
        }
    }

    @Override // e6.g
    public final void cancel() {
        i6.q qVar = this.B;
        if (qVar != null) {
            qVar.f6422c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void l(Exception exc) {
        this.f4484w.c(this.f4486y, exc, this.B.f6422c, 3);
    }

    @Override // com.bumptech.glide.load.data.d
    public final void r(Object obj) {
        this.f4484w.b(this.f4486y, obj, this.B.f6422c, 3, this.f4486y);
    }
}
