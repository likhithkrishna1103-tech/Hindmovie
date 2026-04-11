package bf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hf.i f2073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f2074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f2075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f2076d;

    static {
        hf.i iVar = hf.i.f6114x;
        f2073a = lb.e.h("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f2074b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f2075c = new String[64];
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            be.h.d(binaryString, "toBinaryString(it)");
            String strReplace = ve.b.g("%8s", binaryString).replace(' ', '0');
            be.h.d(strReplace, "replace(...)");
            strArr[i] = strReplace;
        }
        f2076d = strArr;
        String[] strArr2 = f2075c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i10 = iArr[0];
        strArr2[i10 | 8] = l4.a.o(new StringBuilder(), strArr2[i10], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = iArr2[i11];
            int i13 = iArr[0];
            String[] strArr3 = f2075c;
            int i14 = i13 | i12;
            strArr3[i14] = strArr3[i13] + '|' + strArr3[i12];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr3[i13]);
            sb2.append('|');
            strArr3[i14 | 8] = l4.a.o(sb2, strArr3[i12], "|PADDED");
        }
        int length = f2075c.length;
        for (int i15 = 0; i15 < length; i15++) {
            String[] strArr4 = f2075c;
            if (strArr4[i15] == null) {
                strArr4[i15] = f2076d[i15];
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(boolean r10, int r11, int r12, int r13, int r14) {
        /*
            java.lang.String[] r0 = bf.f.f2074b
            int r1 = r0.length
            r2 = 0
            r3 = 1
            if (r13 >= r1) goto La
            r0 = r0[r13]
            goto L18
        La:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r1[r2] = r0
            java.lang.String r0 = "0x%02x"
            java.lang.String r0 = ve.b.g(r0, r1)
        L18:
            r1 = 5
            r4 = 3
            r5 = 2
            r6 = 4
            if (r14 != 0) goto L21
            java.lang.String r13 = ""
            goto L6a
        L21:
            java.lang.String[] r7 = bf.f.f2076d
            if (r13 == r5) goto L68
            if (r13 == r4) goto L68
            if (r13 == r6) goto L60
            r8 = 6
            if (r13 == r8) goto L60
            r8 = 7
            if (r13 == r8) goto L68
            r8 = 8
            if (r13 == r8) goto L68
            java.lang.String[] r8 = bf.f.f2075c
            int r9 = r8.length
            if (r14 >= r9) goto L3e
            r7 = r8[r14]
            be.h.b(r7)
            goto L40
        L3e:
            r7 = r7[r14]
        L40:
            if (r13 != r1) goto L4f
            r8 = r14 & 4
            if (r8 == 0) goto L4f
            java.lang.String r13 = "HEADERS"
            java.lang.String r14 = "PUSH_PROMISE"
            java.lang.String r13 = ie.n.K(r7, r13, r14)
            goto L6a
        L4f:
            if (r13 != 0) goto L5e
            r13 = r14 & 32
            if (r13 == 0) goto L5e
            java.lang.String r13 = "PRIORITY"
            java.lang.String r14 = "COMPRESSED"
            java.lang.String r13 = ie.n.K(r7, r13, r14)
            goto L6a
        L5e:
            r13 = r7
            goto L6a
        L60:
            if (r14 != r3) goto L65
            java.lang.String r13 = "ACK"
            goto L6a
        L65:
            r13 = r7[r14]
            goto L6a
        L68:
            r13 = r7[r14]
        L6a:
            if (r10 == 0) goto L6f
            java.lang.String r10 = "<<"
            goto L71
        L6f:
            java.lang.String r10 = ">>"
        L71:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Object[] r14 = new java.lang.Object[r1]
            r14[r2] = r10
            r14[r3] = r11
            r14[r5] = r12
            r14[r4] = r0
            r14[r6] = r13
            java.lang.String r10 = "%s 0x%08x %5d %-13s %s"
            java.lang.String r10 = ve.b.g(r10, r14)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: bf.f.a(boolean, int, int, int, int):java.lang.String");
    }
}
