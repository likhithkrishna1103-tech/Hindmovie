package g4;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import m4.m0;
import qb.f0;
import qb.q1;
import ua.w;
import ua.x0;
import ua.y;
import v1.p;
import v2.k;
import v2.n;
import v2.o;
import w2.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Comparator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5001v;

    public /* synthetic */ d(int i) {
        this.f5001v = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f5001v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Integer.compare(((e) obj).f5003a.f5006b, ((e) obj2).f5003a.f5006b);
            case 1:
                return Long.compare(((c) obj).f4999b, ((c) obj2).f4999b);
            case 2:
                k2.b bVar = (k2.b) obj;
                k2.b bVar2 = (k2.b) obj2;
                int iCompare = Integer.compare(bVar.f6829c, bVar2.f6829c);
                return iCompare != 0 ? iCompare : bVar.f6828b.compareTo(bVar2.f6828b);
            case 3:
                m0 m0Var = (m0) obj;
                m0 m0Var2 = (m0) obj2;
                int iCompare2 = Integer.compare(m0Var2.f8191b, m0Var.f8191b);
                if (iCompare2 != 0) {
                    return iCompare2;
                }
                int iCompareTo = m0Var.f8192c.compareTo(m0Var2.f8192c);
                return iCompareTo != 0 ? iCompareTo : m0Var.f8193d.compareTo(m0Var2.f8193d);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                m0 m0Var3 = (m0) obj;
                m0 m0Var4 = (m0) obj2;
                int iCompare3 = Integer.compare(m0Var4.f8190a, m0Var3.f8190a);
                if (iCompare3 != 0) {
                    return iCompare3;
                }
                int iCompareTo2 = m0Var4.f8192c.compareTo(m0Var3.f8192c);
                return iCompareTo2 != 0 ? iCompareTo2 : m0Var4.f8193d.compareTo(m0Var3.f8193d);
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return ((n2.d) obj).f8642a.compareTo(((n2.d) obj2).f8642a);
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return ((f0) ((q1) obj)).f10555a.compareTo(((f0) ((q1) obj2)).f10555a);
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i = 0; i < bArr.length; i++) {
                    byte b8 = bArr[i];
                    byte b10 = bArr2[i];
                    if (b8 != b10) {
                        return b8 - b10;
                    }
                }
                return 0;
            case 9:
                return ((File) obj2).getName().compareTo(((File) obj).getName());
            case 10:
                String name = ((File) obj).getName();
                int i10 = tb.a.f;
                return name.substring(0, i10).compareTo(((File) obj2).getName().substring(0, i10));
            case 11:
                return ((p) obj2).f12942j - ((p) obj).f12942j;
            case 12:
                Integer num = (Integer) obj;
                Integer num2 = (Integer) obj2;
                if (num.intValue() == -1) {
                    return num2.intValue() == -1 ? 0 : -1;
                }
                if (num2.intValue() == -1) {
                    return 1;
                }
                return num.intValue() - num2.intValue();
            case 13:
                return Integer.compare(((v2.f) ((List) obj).get(0)).A, ((v2.f) ((List) obj2).get(0)).A);
            case 14:
                List list = (List) obj;
                List list2 = (List) obj2;
                int i11 = 18;
                return w.f(n.c((n) Collections.max(list, new d(17)), (n) Collections.max(list2, new d(17)))).a(list.size(), list2.size()).b((n) Collections.max(list, new d(i11)), (n) Collections.max(list2, new d(i11)), new d(i11)).e();
            case 15:
                return ((v2.e) Collections.max((List) obj)).compareTo((v2.e) Collections.max((List) obj2));
            case 16:
                return ((k) ((List) obj).get(0)).compareTo((k) ((List) obj2).get(0));
            case 17:
                return n.c((n) obj, (n) obj2);
            case 18:
                n nVar = (n) obj;
                n nVar2 = (n) obj2;
                boolean z10 = nVar.f13111z;
                int i12 = nVar.E;
                x0 x0VarA = (z10 && nVar.C) ? o.f13112k : o.f13112k.a();
                boolean z11 = nVar.A.B;
                y yVarB = y.f12407a;
                if (z11) {
                    yVarB = yVarB.b(Integer.valueOf(i12), Integer.valueOf(nVar2.E), o.f13112k.a());
                }
                return yVarB.b(Integer.valueOf(nVar.F), Integer.valueOf(nVar2.F), x0VarA).b(Integer.valueOf(i12), Integer.valueOf(nVar2.E), x0VarA).e();
            case 19:
                return ((s) obj).f13892a - ((s) obj2).f13892a;
            case 20:
                return Float.compare(((s) obj).f13894c, ((s) obj2).f13894c);
            case 21:
                return Integer.compare(((y3.d) obj2).f14796b, ((y3.d) obj).f14796b);
            case 22:
                Date dateA = ((y5.e) obj).a();
                Date dateA2 = ((y5.e) obj2).a();
                if (dateA == null && dateA2 == null) {
                    return 0;
                }
                if (dateA == null) {
                    return 1;
                }
                if (dateA2 == null) {
                    return -1;
                }
                return dateA.compareTo(dateA2);
            default:
                Date dateA3 = ((y5.e) obj).a();
                Date dateA4 = ((y5.e) obj2).a();
                if (dateA3 == null && dateA4 == null) {
                    return 0;
                }
                if (dateA3 == null) {
                    return 1;
                }
                if (dateA4 == null) {
                    return -1;
                }
                return dateA3.compareTo(dateA4);
        }
    }
}
