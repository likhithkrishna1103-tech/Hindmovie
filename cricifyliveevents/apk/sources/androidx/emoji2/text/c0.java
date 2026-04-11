package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f839d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b6.f f841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f842c = 0;

    public c0(b6.f fVar, int i) {
        this.f841b = fVar;
        this.f840a = i;
    }

    public final int a(int i) {
        l1.a aVarB = b();
        int iA = aVarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) aVarB.f7627y;
        int i10 = iA + aVarB.f7624v;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i10) + i10 + 4);
    }

    public final l1.a b() {
        ThreadLocal threadLocal = f839d;
        l1.a aVar = (l1.a) threadLocal.get();
        if (aVar == null) {
            aVar = new l1.a();
            threadLocal.set(aVar);
        }
        l1.b bVar = (l1.b) this.f841b.f1800w;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i = iA + bVar.f7624v;
            int i10 = (this.f840a * 4) + ((ByteBuffer) bVar.f7627y).getInt(i) + i + 4;
            int i11 = ((ByteBuffer) bVar.f7627y).getInt(i10) + i10;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.f7627y;
            aVar.f7627y = byteBuffer;
            if (byteBuffer != null) {
                aVar.f7624v = i11;
                int i12 = i11 - byteBuffer.getInt(i11);
                aVar.f7625w = i12;
                aVar.f7626x = ((ByteBuffer) aVar.f7627y).getShort(i12);
                return aVar;
            }
            aVar.f7624v = 0;
            aVar.f7625w = 0;
            aVar.f7626x = 0;
        }
        return aVar;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        l1.a aVarB = b();
        int iA = aVarB.a(4);
        sb.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) aVarB.f7627y).getInt(iA + aVarB.f7624v) : 0));
        sb.append(", codepoints:");
        l1.a aVarB2 = b();
        int iA2 = aVarB2.a(16);
        if (iA2 != 0) {
            int i10 = iA2 + aVarB2.f7624v;
            i = ((ByteBuffer) aVarB2.f7627y).getInt(((ByteBuffer) aVarB2.f7627y).getInt(i10) + i10);
        } else {
            i = 0;
        }
        for (int i11 = 0; i11 < i; i11++) {
            sb.append(Integer.toHexString(a(i11)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
