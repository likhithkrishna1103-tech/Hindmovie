package va;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements k {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final e f13441w = new e();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f13442u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f13443v;

    public f(za.c cVar) {
        this.f13442u = cVar;
        this.f13443v = f13441w;
    }

    @Override // va.k
    public void a(j jVar, int i) throws IOException {
        int[] iArr = (int[]) this.f13443v;
        try {
            jVar.read((byte[]) this.f13442u, iArr[0], i);
            iArr[0] = iArr[0] + i;
        } finally {
            jVar.close();
        }
    }

    public f(byte[] bArr, int[] iArr) {
        this.f13442u = bArr;
        this.f13443v = iArr;
    }
}
