package a3;

import java.util.ArrayList;
import v1.n0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f164e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f166h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f167j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f168k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f169l;

    public e(ArrayList arrayList, int i, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f, String str) {
        this.f160a = arrayList;
        this.f161b = i;
        this.f162c = i10;
        this.f163d = i11;
        this.f164e = i12;
        this.f = i13;
        this.f165g = i14;
        this.f166h = i15;
        this.i = i16;
        this.f167j = i17;
        this.f168k = f;
        this.f169l = str;
    }

    public static e a(y1.t tVar) throws n0 {
        String str;
        int i;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        float f;
        int i15;
        int i16;
        try {
            tVar.K(4);
            int iX = (tVar.x() & 3) + 1;
            if (iX == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iX2 = tVar.x() & 31;
            for (int i17 = 0; i17 < iX2; i17++) {
                int iD = tVar.D();
                int i18 = tVar.f14610b;
                tVar.K(iD);
                byte[] bArr = tVar.f14609a;
                byte[] bArr2 = new byte[iD + 4];
                System.arraycopy(y1.e.f14568a, 0, bArr2, 0, 4);
                System.arraycopy(bArr, i18, bArr2, 4, iD);
                arrayList.add(bArr2);
            }
            int iX3 = tVar.x();
            for (int i19 = 0; i19 < iX3; i19++) {
                int iD2 = tVar.D();
                int i20 = tVar.f14610b;
                tVar.K(iD2);
                byte[] bArr3 = tVar.f14609a;
                byte[] bArr4 = new byte[iD2 + 4];
                System.arraycopy(y1.e.f14568a, 0, bArr4, 0, 4);
                System.arraycopy(bArr3, i20, bArr4, 4, iD2);
                arrayList.add(bArr4);
            }
            if (iX2 > 0) {
                z1.n nVarJ = z1.o.j((byte[]) arrayList.get(0), 4, ((byte[]) arrayList.get(0)).length);
                int i21 = nVarJ.f15109e;
                int i22 = nVarJ.f;
                int i23 = nVarJ.f15111h + 8;
                int i24 = nVarJ.i + 8;
                int i25 = nVarJ.f15118p;
                int i26 = nVarJ.f15119q;
                int i27 = nVarJ.f15120r;
                int i28 = nVarJ.f15121s;
                float f10 = nVarJ.f15110g;
                int i29 = nVarJ.f15105a;
                int i30 = nVarJ.f15106b;
                int i31 = nVarJ.f15107c;
                byte[] bArr5 = y1.e.f14568a;
                str = String.format("avc1.%02X%02X%02X", Integer.valueOf(i29), Integer.valueOf(i30), Integer.valueOf(i31));
                i14 = i28;
                f = f10;
                i15 = i26;
                i16 = i27;
                i12 = i24;
                i13 = i25;
                i10 = i22;
                i11 = i23;
                i = i21;
            } else {
                str = null;
                i = -1;
                i10 = -1;
                i11 = -1;
                i12 = -1;
                i13 = -1;
                i14 = 16;
                f = 1.0f;
                i15 = -1;
                i16 = -1;
            }
            return new e(arrayList, iX, i, i10, i11, i12, i13, i15, i16, i14, f, str);
        } catch (ArrayIndexOutOfBoundsException e9) {
            throw n0.a(e9, "Error parsing AVC config");
        }
    }
}
