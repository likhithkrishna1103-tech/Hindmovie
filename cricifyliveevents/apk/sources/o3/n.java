package o3;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.Objects;
import ua.i0;
import ua.z0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i0 f9478c;

    public n(String str, String str2, z0 z0Var) {
        super(str);
        y1.d.b(!z0Var.isEmpty());
        this.f9477b = str2;
        i0 i0VarK = i0.k(z0Var);
        this.f9478c = i0VarK;
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
    @Override // o3.i, v1.k0
    public final void c(v1.i0 i0Var) {
        byte b8;
        String str = this.f9466a;
        switch (str.hashCode()) {
            case 82815:
                b8 = !str.equals("TAL") ? (byte) -1 : (byte) 0;
                break;
            case 82878:
                b8 = !str.equals("TCM") ? (byte) -1 : (byte) 1;
                break;
            case 82897:
                b8 = !str.equals("TDA") ? (byte) -1 : (byte) 2;
                break;
            case 83253:
                b8 = !str.equals("TP1") ? (byte) -1 : (byte) 3;
                break;
            case 83254:
                b8 = !str.equals("TP2") ? (byte) -1 : (byte) 4;
                break;
            case 83255:
                b8 = !str.equals("TP3") ? (byte) -1 : (byte) 5;
                break;
            case 83341:
                b8 = !str.equals("TRK") ? (byte) -1 : (byte) 6;
                break;
            case 83378:
                b8 = !str.equals("TT2") ? (byte) -1 : (byte) 7;
                break;
            case 83536:
                b8 = !str.equals("TXT") ? (byte) -1 : (byte) 8;
                break;
            case 83552:
                b8 = !str.equals("TYE") ? (byte) -1 : (byte) 9;
                break;
            case 2567331:
                b8 = !str.equals("TALB") ? (byte) -1 : (byte) 10;
                break;
            case 2569357:
                b8 = !str.equals("TCOM") ? (byte) -1 : (byte) 11;
                break;
            case 2569358:
                b8 = !str.equals("TCON") ? (byte) -1 : (byte) 12;
                break;
            case 2569891:
                b8 = !str.equals("TDAT") ? (byte) -1 : (byte) 13;
                break;
            case 2570401:
                b8 = !str.equals("TDRC") ? (byte) -1 : (byte) 14;
                break;
            case 2570410:
                b8 = !str.equals("TDRL") ? (byte) -1 : (byte) 15;
                break;
            case 2571565:
                b8 = !str.equals("TEXT") ? (byte) -1 : (byte) 16;
                break;
            case 2575251:
                b8 = !str.equals("TIT2") ? (byte) -1 : (byte) 17;
                break;
            case 2581512:
                b8 = !str.equals("TPE1") ? (byte) -1 : (byte) 18;
                break;
            case 2581513:
                b8 = !str.equals("TPE2") ? (byte) -1 : (byte) 19;
                break;
            case 2581514:
                b8 = !str.equals("TPE3") ? (byte) -1 : (byte) 20;
                break;
            case 2583398:
                b8 = !str.equals("TRCK") ? (byte) -1 : (byte) 21;
                break;
            case 2590194:
                b8 = !str.equals("TYER") ? (byte) -1 : (byte) 22;
                break;
            default:
                b8 = -1;
                break;
        }
        i0 i0Var2 = this.f9478c;
        try {
            switch (b8) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                case 10:
                    i0Var.f12720c = (CharSequence) i0Var2.get(0);
                    break;
                case 1:
                case 11:
                    i0Var.f12741z = (CharSequence) i0Var2.get(0);
                    break;
                case 2:
                case 13:
                    String str2 = (String) i0Var2.get(0);
                    int i = Integer.parseInt(str2.substring(2, 4));
                    int i10 = Integer.parseInt(str2.substring(0, 2));
                    i0Var.f12735t = Integer.valueOf(i);
                    i0Var.f12736u = Integer.valueOf(i10);
                    break;
                case 3:
                case 18:
                    i0Var.f12719b = (CharSequence) i0Var2.get(0);
                    break;
                case g1.h.LONG_FIELD_NUMBER /* 4 */:
                case 19:
                    i0Var.f12721d = (CharSequence) i0Var2.get(0);
                    break;
                case g1.h.STRING_FIELD_NUMBER /* 5 */:
                case 20:
                    i0Var.A = (CharSequence) i0Var2.get(0);
                    break;
                case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                case 21:
                    String str3 = (String) i0Var2.get(0);
                    int i11 = a0.f14551a;
                    String[] strArrSplit = str3.split("/", -1);
                    int i12 = Integer.parseInt(strArrSplit[0]);
                    Integer numValueOf = strArrSplit.length > 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null;
                    i0Var.f12729n = Integer.valueOf(i12);
                    i0Var.f12730o = numValueOf;
                    break;
                case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                case 17:
                    i0Var.f12718a = (CharSequence) i0Var2.get(0);
                    break;
                case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                case 16:
                    i0Var.f12740y = (CharSequence) i0Var2.get(0);
                    break;
                case 9:
                case 22:
                    i0Var.f12734s = Integer.valueOf(Integer.parseInt((String) i0Var2.get(0)));
                    break;
                case 12:
                    Integer numF = com.bumptech.glide.d.F((String) i0Var2.get(0));
                    if (numF != null) {
                        String strA = j.a(numF.intValue());
                        if (strA != null) {
                            i0Var.D = strA;
                        }
                    } else {
                        i0Var.D = (CharSequence) i0Var2.get(0);
                    }
                    break;
                case 14:
                    ArrayList arrayListD = d((String) i0Var2.get(0));
                    int size = arrayListD.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                i0Var.f12736u = (Integer) arrayListD.get(2);
                            }
                        }
                        i0Var.f12735t = (Integer) arrayListD.get(1);
                    }
                    i0Var.f12734s = (Integer) arrayListD.get(0);
                    break;
                case 15:
                    ArrayList arrayListD2 = d((String) i0Var2.get(0));
                    int size2 = arrayListD2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                i0Var.f12739x = (Integer) arrayListD2.get(2);
                            }
                        }
                        i0Var.f12738w = (Integer) arrayListD2.get(1);
                    }
                    i0Var.f12737v = (Integer) arrayListD2.get(0);
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
            if (Objects.equals(this.f9466a, nVar.f9466a) && Objects.equals(this.f9477b, nVar.f9477b) && this.f9478c.equals(nVar.f9478c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iE = l0.e.e(527, 31, this.f9466a);
        String str = this.f9477b;
        return this.f9478c.hashCode() + ((iE + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // o3.i
    public final String toString() {
        return this.f9466a + ": description=" + this.f9477b + ": values=" + this.f9478c;
    }
}
