package z6;

import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements g, com.bumptech.glide.load.data.c {
    public List A;
    public int B;
    public volatile d7.s C;
    public File D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f15232v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h f15233w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f f15234x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f15235y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public x6.e f15236z;

    public c(List list, h hVar, f fVar) {
        this.f15232v = list;
        this.f15233w = hVar;
        this.f15234x = fVar;
    }

    @Override // z6.g
    public final boolean b() {
        while (true) {
            List list = this.A;
            boolean z10 = false;
            if (list != null && this.B < list.size()) {
                this.C = null;
                while (!z10 && this.B < this.A.size()) {
                    List list2 = this.A;
                    int i = this.B;
                    this.B = i + 1;
                    d7.t tVar = (d7.t) list2.get(i);
                    File file = this.D;
                    h hVar = this.f15233w;
                    this.C = tVar.a(file, hVar.f15263e, hVar.f, hVar.i);
                    if (this.C != null && this.f15233w.c(this.C.f3509c.a()) != null) {
                        this.C.f3509c.f(this.f15233w.f15271o, this);
                        z10 = true;
                    }
                }
                return z10;
            }
            int i10 = this.f15235y + 1;
            this.f15235y = i10;
            if (i10 >= this.f15232v.size()) {
                return false;
            }
            x6.e eVar = (x6.e) this.f15232v.get(this.f15235y);
            h hVar2 = this.f15233w;
            File fileF = hVar2.f15265h.a().f(new d(eVar, hVar2.f15270n));
            this.D = fileF;
            if (fileF != null) {
                this.f15236z = eVar;
                this.A = this.f15233w.f15261c.b().g(fileF);
                this.B = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public final void c(Exception exc) {
        this.f15234x.a(this.f15236z, exc, this.C.f3509c, 3);
    }

    @Override // z6.g
    public final void cancel() {
        d7.s sVar = this.C;
        if (sVar != null) {
            sVar.f3509c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public final void d(Object obj) {
        this.f15234x.c(this.f15236z, obj, this.C.f3509c, 3, this.f15236z);
    }
}
