package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f1211d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ub.o f1213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f1214c = 0;

    public y(ub.o oVar, int i) {
        this.f1213b = oVar;
        this.f1212a = i;
    }

    public final int a(int i) {
        f1.a aVarB = b();
        int iA = aVarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) aVarB.f4694x;
        int i10 = iA + aVarB.f4691u;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i10) + i10 + 4);
    }

    public final f1.a b() {
        ThreadLocal threadLocal = f1211d;
        f1.a aVar = (f1.a) threadLocal.get();
        if (aVar == null) {
            aVar = new f1.a();
            threadLocal.set(aVar);
        }
        f1.b bVar = (f1.b) this.f1213b.f12868v;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i = iA + bVar.f4691u;
            int i10 = (this.f1212a * 4) + ((ByteBuffer) bVar.f4694x).getInt(i) + i + 4;
            int i11 = ((ByteBuffer) bVar.f4694x).getInt(i10) + i10;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.f4694x;
            aVar.f4694x = byteBuffer;
            if (byteBuffer != null) {
                aVar.f4691u = i11;
                int i12 = i11 - byteBuffer.getInt(i11);
                aVar.f4692v = i12;
                aVar.f4693w = ((ByteBuffer) aVar.f4694x).getShort(i12);
                return aVar;
            }
            aVar.f4691u = 0;
            aVar.f4692v = 0;
            aVar.f4693w = 0;
        }
        return aVar;
    }

    public final String toString() {
        int i;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        f1.a aVarB = b();
        int iA = aVarB.a(4);
        sb2.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) aVarB.f4694x).getInt(iA + aVarB.f4691u) : 0));
        sb2.append(", codepoints:");
        f1.a aVarB2 = b();
        int iA2 = aVarB2.a(16);
        if (iA2 != 0) {
            int i10 = iA2 + aVarB2.f4691u;
            i = ((ByteBuffer) aVarB2.f4694x).getInt(((ByteBuffer) aVarB2.f4694x).getInt(i10) + i10);
        } else {
            i = 0;
        }
        for (int i11 = 0; i11 < i; i11++) {
            sb2.append(Integer.toHexString(a(i11)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
