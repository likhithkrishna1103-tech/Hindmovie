package w2;

import java.util.ArrayList;
import p1.n0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f13603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13607e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f13609h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f13610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f13611k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f13612l;

    public d(ArrayList arrayList, int i, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f, String str) {
        this.f13603a = arrayList;
        this.f13604b = i;
        this.f13605c = i10;
        this.f13606d = i11;
        this.f13607e = i12;
        this.f = i13;
        this.f13608g = i14;
        this.f13609h = i15;
        this.i = i16;
        this.f13610j = i17;
        this.f13611k = f;
        this.f13612l = str;
    }

    public static d a(s1.u uVar) throws n0 {
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
            uVar.K(4);
            int iX = (uVar.x() & 3) + 1;
            if (iX == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iX2 = uVar.x() & 31;
            for (int i17 = 0; i17 < iX2; i17++) {
                int iD = uVar.D();
                int i18 = uVar.f11710b;
                uVar.K(iD);
                byte[] bArr = uVar.f11709a;
                byte[] bArr2 = new byte[iD + 4];
                System.arraycopy(s1.e.f11662a, 0, bArr2, 0, 4);
                System.arraycopy(bArr, i18, bArr2, 4, iD);
                arrayList.add(bArr2);
            }
            int iX3 = uVar.x();
            for (int i19 = 0; i19 < iX3; i19++) {
                int iD2 = uVar.D();
                int i20 = uVar.f11710b;
                uVar.K(iD2);
                byte[] bArr3 = uVar.f11709a;
                byte[] bArr4 = new byte[iD2 + 4];
                System.arraycopy(s1.e.f11662a, 0, bArr4, 0, 4);
                System.arraycopy(bArr3, i20, bArr4, 4, iD2);
                arrayList.add(bArr4);
            }
            if (iX2 > 0) {
                t1.o oVarJ = t1.p.j((byte[]) arrayList.get(0), 4, ((byte[]) arrayList.get(0)).length);
                int i21 = oVarJ.f12044e;
                int i22 = oVarJ.f;
                int i23 = oVarJ.f12046h + 8;
                int i24 = oVarJ.i + 8;
                int i25 = oVarJ.f12053p;
                int i26 = oVarJ.f12054q;
                int i27 = oVarJ.f12055r;
                int i28 = oVarJ.f12056s;
                float f4 = oVarJ.f12045g;
                int i29 = oVarJ.f12040a;
                int i30 = oVarJ.f12041b;
                int i31 = oVarJ.f12042c;
                byte[] bArr5 = s1.e.f11662a;
                str = String.format("avc1.%02X%02X%02X", Integer.valueOf(i29), Integer.valueOf(i30), Integer.valueOf(i31));
                i14 = i28;
                f = f4;
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
            return new d(arrayList, iX, i, i10, i11, i12, i13, i15, i16, i14, f, str);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw n0.a(e10, "Error parsing AVC config");
        }
    }
}
