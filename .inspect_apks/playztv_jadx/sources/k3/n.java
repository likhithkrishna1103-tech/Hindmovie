package k3;

import aa.c1;
import aa.j0;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Objects;
import p1.i0;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f7013c;

    public n(String str, String str2, c1 c1Var) {
        super(str);
        s1.d.b(!c1Var.isEmpty());
        this.f7012b = str2;
        j0 j0VarR = j0.r(c1Var);
        this.f7013c = j0VarR;
    }

    public static ArrayList d(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            }
            if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            }
            if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // k3.i, p1.k0
    public final void a(i0 i0Var) {
        byte b10;
        String str = this.f7001a;
        switch (str.hashCode()) {
            case 82815:
                b10 = !str.equals("TAL") ? (byte) -1 : (byte) 0;
                break;
            case 82878:
                b10 = !str.equals("TCM") ? (byte) -1 : (byte) 1;
                break;
            case 82897:
                b10 = !str.equals("TDA") ? (byte) -1 : (byte) 2;
                break;
            case 83253:
                b10 = !str.equals("TP1") ? (byte) -1 : (byte) 3;
                break;
            case 83254:
                b10 = !str.equals("TP2") ? (byte) -1 : (byte) 4;
                break;
            case 83255:
                b10 = !str.equals("TP3") ? (byte) -1 : (byte) 5;
                break;
            case 83341:
                b10 = !str.equals("TRK") ? (byte) -1 : (byte) 6;
                break;
            case 83378:
                b10 = !str.equals("TT2") ? (byte) -1 : (byte) 7;
                break;
            case 83536:
                b10 = !str.equals("TXT") ? (byte) -1 : (byte) 8;
                break;
            case 83552:
                b10 = !str.equals("TYE") ? (byte) -1 : (byte) 9;
                break;
            case 2567331:
                b10 = !str.equals("TALB") ? (byte) -1 : (byte) 10;
                break;
            case 2569357:
                b10 = !str.equals("TCOM") ? (byte) -1 : (byte) 11;
                break;
            case 2569358:
                b10 = !str.equals("TCON") ? (byte) -1 : (byte) 12;
                break;
            case 2569891:
                b10 = !str.equals("TDAT") ? (byte) -1 : (byte) 13;
                break;
            case 2570401:
                b10 = !str.equals("TDRC") ? (byte) -1 : (byte) 14;
                break;
            case 2570410:
                b10 = !str.equals("TDRL") ? (byte) -1 : (byte) 15;
                break;
            case 2571565:
                b10 = !str.equals("TEXT") ? (byte) -1 : (byte) 16;
                break;
            case 2575251:
                b10 = !str.equals("TIT2") ? (byte) -1 : (byte) 17;
                break;
            case 2581512:
                b10 = !str.equals("TPE1") ? (byte) -1 : (byte) 18;
                break;
            case 2581513:
                b10 = !str.equals("TPE2") ? (byte) -1 : (byte) 19;
                break;
            case 2581514:
                b10 = !str.equals("TPE3") ? (byte) -1 : (byte) 20;
                break;
            case 2583398:
                b10 = !str.equals("TRCK") ? (byte) -1 : (byte) 21;
                break;
            case 2590194:
                b10 = !str.equals("TYER") ? (byte) -1 : (byte) 22;
                break;
            default:
                b10 = -1;
                break;
        }
        j0 j0Var = this.f7013c;
        try {
            switch (b10) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                case 10:
                    i0Var.f9787c = (CharSequence) j0Var.get(0);
                    break;
                case 1:
                case 11:
                    i0Var.f9808z = (CharSequence) j0Var.get(0);
                    break;
                case 2:
                case 13:
                    String str2 = (String) j0Var.get(0);
                    int i = Integer.parseInt(str2.substring(2, 4));
                    int i10 = Integer.parseInt(str2.substring(0, 2));
                    i0Var.f9802t = Integer.valueOf(i);
                    i0Var.f9803u = Integer.valueOf(i10);
                    break;
                case 3:
                case 18:
                    i0Var.f9786b = (CharSequence) j0Var.get(0);
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                case 19:
                    i0Var.f9788d = (CharSequence) j0Var.get(0);
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                case 20:
                    i0Var.A = (CharSequence) j0Var.get(0);
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                case 21:
                    String str3 = (String) j0Var.get(0);
                    int i11 = b0.f11647a;
                    String[] strArrSplit = str3.split("/", -1);
                    int i12 = Integer.parseInt(strArrSplit[0]);
                    Integer numValueOf = strArrSplit.length > 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null;
                    i0Var.f9796n = Integer.valueOf(i12);
                    i0Var.f9797o = numValueOf;
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                case 17:
                    i0Var.f9785a = (CharSequence) j0Var.get(0);
                    break;
                case 8:
                case 16:
                    i0Var.f9807y = (CharSequence) j0Var.get(0);
                    break;
                case 9:
                case 22:
                    i0Var.f9801s = Integer.valueOf(Integer.parseInt((String) j0Var.get(0)));
                    break;
                case 12:
                    Integer numU = q1.c.U((String) j0Var.get(0));
                    if (numU != null) {
                        String strA = j.a(numU.intValue());
                        if (strA != null) {
                            i0Var.D = strA;
                        }
                    } else {
                        i0Var.D = (CharSequence) j0Var.get(0);
                    }
                    break;
                case 14:
                    ArrayList arrayListD = d((String) j0Var.get(0));
                    int size = arrayListD.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                i0Var.f9803u = (Integer) arrayListD.get(2);
                            }
                        }
                        i0Var.f9802t = (Integer) arrayListD.get(1);
                    }
                    i0Var.f9801s = (Integer) arrayListD.get(0);
                    break;
                case 15:
                    ArrayList arrayListD2 = d((String) j0Var.get(0));
                    int size2 = arrayListD2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                i0Var.f9806x = (Integer) arrayListD2.get(2);
                            }
                        }
                        i0Var.f9805w = (Integer) arrayListD2.get(1);
                    }
                    i0Var.f9804v = (Integer) arrayListD2.get(0);
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n.class == obj.getClass()) {
            n nVar = (n) obj;
            if (Objects.equals(this.f7001a, nVar.f7001a) && Objects.equals(this.f7012b, nVar.f7012b) && this.f7013c.equals(nVar.f7013c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iH = e6.j.h(527, 31, this.f7001a);
        String str = this.f7012b;
        return this.f7013c.hashCode() + ((iH + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // k3.i
    public final String toString() {
        return this.f7001a + ": description=" + this.f7012b + ": values=" + this.f7013c;
    }
}
