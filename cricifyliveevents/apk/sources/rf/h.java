package rf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ag.h f11080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f11081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f11082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f11083d;

    static {
        ag.h hVar = ag.h.f430y;
        f11080a = ka.f.d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f11081b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f11082c = new String[64];
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            ge.i.d(binaryString, "toBinaryString(...)");
            String strReplace = lf.f.c("%8s", binaryString).replace(' ', '0');
            ge.i.d(strReplace, "replace(...)");
            strArr[i] = strReplace;
        }
        f11083d = strArr;
        String[] strArr2 = f11082c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i10 = iArr[0];
        strArr2[i10 | 8] = q4.a.q(new StringBuilder(), strArr2[i10], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = iArr2[i11];
            int i13 = iArr[0];
            String[] strArr3 = f11082c;
            int i14 = i13 | i12;
            strArr3[i14] = strArr3[i13] + '|' + strArr3[i12];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i13]);
            sb.append('|');
            strArr3[i14 | 8] = q4.a.q(sb, strArr3[i12], "|PADDED");
        }
        int length = f11082c.length;
        for (int i15 = 0; i15 < length; i15++) {
            String[] strArr4 = f11082c;
            if (strArr4[i15] == null) {
                strArr4[i15] = f11083d[i15];
            }
        }
    }

    public static String a(int i) {
        String[] strArr = f11081b;
        return i < strArr.length ? strArr[i] : lf.f.c("0x%02x", Integer.valueOf(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(boolean r9, int r10, int r11, int r12, int r13) {
        /*
            java.lang.String r0 = a(r12)
            r1 = 1
            r2 = 5
            r3 = 3
            r4 = 2
            r5 = 4
            if (r13 != 0) goto Le
            java.lang.String r12 = ""
            goto L57
        Le:
            java.lang.String[] r6 = rf.h.f11083d
            if (r12 == r4) goto L55
            if (r12 == r3) goto L55
            if (r12 == r5) goto L4d
            r7 = 6
            if (r12 == r7) goto L4d
            r7 = 7
            if (r12 == r7) goto L55
            r7 = 8
            if (r12 == r7) goto L55
            java.lang.String[] r7 = rf.h.f11082c
            int r8 = r7.length
            if (r13 >= r8) goto L2b
            r6 = r7[r13]
            ge.i.b(r6)
            goto L2d
        L2b:
            r6 = r6[r13]
        L2d:
            if (r12 != r2) goto L3c
            r7 = r13 & 4
            if (r7 == 0) goto L3c
            java.lang.String r12 = "HEADERS"
            java.lang.String r13 = "PUSH_PROMISE"
            java.lang.String r12 = ne.o.X(r6, r12, r13)
            goto L57
        L3c:
            if (r12 != 0) goto L4b
            r12 = r13 & 32
            if (r12 == 0) goto L4b
            java.lang.String r12 = "PRIORITY"
            java.lang.String r13 = "COMPRESSED"
            java.lang.String r12 = ne.o.X(r6, r12, r13)
            goto L57
        L4b:
            r12 = r6
            goto L57
        L4d:
            if (r13 != r1) goto L52
            java.lang.String r12 = "ACK"
            goto L57
        L52:
            r12 = r6[r13]
            goto L57
        L55:
            r12 = r6[r13]
        L57:
            if (r9 == 0) goto L5c
            java.lang.String r9 = "<<"
            goto L5e
        L5c:
            java.lang.String r9 = ">>"
        L5e:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Object[] r13 = new java.lang.Object[r2]
            r2 = 0
            r13[r2] = r9
            r13[r1] = r10
            r13[r4] = r11
            r13[r3] = r0
            r13[r5] = r12
            java.lang.String r9 = "%s 0x%08x %5d %-13s %s"
            java.lang.String r9 = lf.f.c(r9, r13)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: rf.h.b(boolean, int, int, int, int):java.lang.String");
    }

    public static String c(int i, int i10, long j4, boolean z10) {
        return lf.f.c("%s 0x%08x %5d %-13s %d", z10 ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i10), a(8), Long.valueOf(j4));
    }
}
