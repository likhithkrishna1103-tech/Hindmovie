package x3;

import e6.j;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import s1.b0;
import s1.u;
import t3.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements m {
    public static final Pattern A = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f14226u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v3.b f14227v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public LinkedHashMap f14229x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f14230y = -3.4028235E38f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f14231z = -3.4028235E38f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final u f14228w = new u();

    public a(List list) {
        if (list == null || list.isEmpty()) {
            this.f14226u = false;
            this.f14227v = null;
            return;
        }
        this.f14226u = true;
        String strO = b0.o((byte[]) list.get(0));
        s1.d.b(strO.startsWith("Format:"));
        v3.b bVarA = v3.b.a(strO);
        bVarA.getClass();
        this.f14227v = bVarA;
        b(new u((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }

    public static int a(long j5, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) arrayList.get(size)).longValue() == j5) {
                return size;
            }
            if (((Long) arrayList.get(size)).longValue() < j5) {
                i = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i, Long.valueOf(j5));
        arrayList2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) arrayList2.get(i - 1)));
        return i;
    }

    public static long c(String str) {
        Matcher matcher = A.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        int i = b0.f11647a;
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(strGroup) * 3600000000L);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(s1.u r39, java.nio.charset.Charset r40) {
        /*
            Method dump skipped, instruction units count: 850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.a.b(s1.u, java.nio.charset.Charset):void");
    }

    @Override // t3.m
    public final /* synthetic */ t3.d h(byte[] bArr, int i, int i10) {
        return j.a(this, bArr, i10);
    }

    @Override // t3.m
    public final int m() {
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
    @Override // t3.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(byte[] r44, int r45, int r46, t3.l r47, s1.h r48) {
        /*
            Method dump skipped, instruction units count: 998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.a.n(byte[], int, int, t3.l, s1.h):void");
    }

    @Override // t3.m
    public final /* synthetic */ void reset() {
    }
}
