package b4;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import x3.g;
import x3.p;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements p {
    public static final Pattern B = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f1757v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a f1758w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public LinkedHashMap f1760y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f1761z = -3.4028235E38f;
    public float A = -3.4028235E38f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final t f1759x = new t();

    public b(List list) {
        if (list == null || list.isEmpty()) {
            this.f1757v = false;
            this.f1758w = null;
            return;
        }
        this.f1757v = true;
        String strO = a0.o((byte[]) list.get(0));
        y1.d.b(strO.startsWith("Format:"));
        a aVarA = a.a(strO);
        aVarA.getClass();
        this.f1758w = aVarA;
        b(new t((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }

    public static int a(long j4, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) arrayList.get(size)).longValue() == j4) {
                return size;
            }
            if (((Long) arrayList.get(size)).longValue() < j4) {
                i = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i, Long.valueOf(j4));
        arrayList2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) arrayList2.get(i - 1)));
        return i;
    }

    public static long c(String str) {
        Matcher matcher = B.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        int i = a0.f14551a;
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(strGroup) * 3600000000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
    @Override // x3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(byte[] r44, int r45, int r46, x3.o r47, y1.h r48) {
        /*
            Method dump skipped, instruction units count: 998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.b.C(byte[], int, int, x3.o, y1.h):void");
    }

    @Override // x3.p
    public final int D() {
        return 1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(y1.t r39, java.nio.charset.Charset r40) {
        /*
            Method dump skipped, instruction units count: 850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.b.b(y1.t, java.nio.charset.Charset):void");
    }

    @Override // x3.p
    public final /* synthetic */ g r(byte[] bArr, int i, int i10) {
        return l0.e.a(this, bArr, i10);
    }

    @Override // x3.p
    public final /* synthetic */ void reset() {
    }
}
