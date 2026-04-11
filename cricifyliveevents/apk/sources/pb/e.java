package pb;

import f9.b0;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements j {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final b0 f10155x = new b0(21);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f10156v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f10157w;

    public e(tb.c cVar) {
        this.f10156v = cVar;
        this.f10157w = f10155x;
    }

    @Override // pb.j
    public void a(i iVar, int i) throws IOException {
        int[] iArr = (int[]) this.f10157w;
        try {
            iVar.read((byte[]) this.f10156v, iArr[0], i);
            iArr[0] = iArr[0] + i;
        } finally {
            iVar.close();
        }
    }

    public e(byte[] bArr, int[] iArr) {
        this.f10156v = bArr;
        this.f10157w = iArr;
    }
}
