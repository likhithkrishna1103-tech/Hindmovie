package c4;

import aa.a1;
import aa.w;
import aa.y;
import androidx.media3.decoder.DecoderInputBuffer;
import i4.p0;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import p1.q;
import r2.l;
import r2.o;
import r2.p;
import wa.f0;
import wa.q1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Comparator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2481u;

    public /* synthetic */ d(int i) {
        this.f2481u = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f2481u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Integer.compare(((e) obj).f2483a.f2486b, ((e) obj2).f2483a.f2486b);
            case 1:
                return Long.compare(((c) obj).f2479b, ((c) obj2).f2479b);
            case 2:
                e2.b bVar = (e2.b) obj;
                e2.b bVar2 = (e2.b) obj2;
                int iCompare = Integer.compare(bVar.f4297c, bVar2.f4297c);
                return iCompare != 0 ? iCompare : bVar.f4296b.compareTo(bVar2.f4296b);
            case 3:
                return ((h2.d) obj).f5666a.compareTo(((h2.d) obj2).f5666a);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                p0 p0Var = (p0) obj;
                p0 p0Var2 = (p0) obj2;
                int iCompare2 = Integer.compare(p0Var2.f6249b, p0Var.f6249b);
                if (iCompare2 != 0) {
                    return iCompare2;
                }
                int iCompareTo = p0Var.f6250c.compareTo(p0Var2.f6250c);
                return iCompareTo != 0 ? iCompareTo : p0Var.f6251d.compareTo(p0Var2.f6251d);
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                p0 p0Var3 = (p0) obj;
                p0 p0Var4 = (p0) obj2;
                int iCompare3 = Integer.compare(p0Var4.f6248a, p0Var3.f6248a);
                if (iCompare3 != 0) {
                    return iCompare3;
                }
                int iCompareTo2 = p0Var4.f6250c.compareTo(p0Var3.f6250c);
                return iCompareTo2 != 0 ? iCompareTo2 : p0Var4.f6251d.compareTo(p0Var3.f6251d);
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i = 0; i < bArr.length; i++) {
                    byte b10 = bArr[i];
                    byte b11 = bArr2[i];
                    if (b10 != b11) {
                        return b10 - b11;
                    }
                }
                return 0;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                Date dateA = ((oc.e) obj).a();
                Date dateA2 = ((oc.e) obj2).a();
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
            case 8:
                Date dateA3 = ((oc.e) obj).a();
                Date dateA4 = ((oc.e) obj2).a();
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
            case 9:
                return ((q) obj2).f10019j - ((q) obj).f10019j;
            case 10:
                Integer num = (Integer) obj;
                Integer num2 = (Integer) obj2;
                if (num.intValue() == -1) {
                    return num2.intValue() == -1 ? 0 : -1;
                }
                if (num2.intValue() == -1) {
                    return 1;
                }
                return num.intValue() - num2.intValue();
            case 11:
                return Integer.compare(((r2.f) ((List) obj).get(0)).f11316z, ((r2.f) ((List) obj2).get(0)).f11316z);
            case 12:
                List list = (List) obj;
                List list2 = (List) obj2;
                int i10 = 16;
                return w.f(o.c((o) Collections.max(list, new d(15)), (o) Collections.max(list2, new d(15)))).a(list.size(), list2.size()).b((o) Collections.max(list, new d(i10)), (o) Collections.max(list2, new d(i10)), new d(i10)).e();
            case 13:
                return ((r2.e) Collections.max((List) obj)).compareTo((r2.e) Collections.max((List) obj2));
            case 14:
                return ((l) ((List) obj).get(0)).compareTo((l) ((List) obj2).get(0));
            case 15:
                return o.c((o) obj, (o) obj2);
            case 16:
                o oVar = (o) obj;
                o oVar2 = (o) obj2;
                boolean z2 = oVar.f11339y;
                int i11 = oVar.D;
                a1 a1VarA = (z2 && oVar.B) ? p.f11341k : p.f11341k.a();
                boolean z10 = oVar.f11340z.B;
                y yVarB = y.f763a;
                if (z10) {
                    yVarB = yVarB.b(Integer.valueOf(i11), Integer.valueOf(oVar2.D), p.f11341k.a());
                }
                return yVarB.b(Integer.valueOf(oVar.E), Integer.valueOf(oVar2.E), a1VarA).b(Integer.valueOf(i11), Integer.valueOf(oVar2.D), a1VarA).e();
            case 17:
                return ((s2.q) obj).f11776a - ((s2.q) obj2).f11776a;
            case 18:
                return Float.compare(((s2.q) obj).f11778c, ((s2.q) obj2).f11778c);
            case 19:
                return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
            case 20:
                return ((f0) ((q1) obj)).f13852a.compareTo(((f0) ((q1) obj2)).f13852a);
            case 21:
                return Integer.compare(((u3.d) obj2).f12720b, ((u3.d) obj).f12720b);
            case 22:
                return ((File) obj2).getName().compareTo(((File) obj).getName());
            default:
                String name = ((File) obj).getName();
                int i12 = za.a.f;
                return name.substring(0, i12).compareTo(((File) obj2).getName().substring(0, i12));
        }
    }
}
