package bg;

import ge.i;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f1917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f1918b;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(ne.a.f9126a);
        i.d(bytes, "getBytes(...)");
        f1917a = bytes;
        f1918b = new long[]{-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L, 9999999999999999L, 99999999999999999L, 999999999999999999L, Long.MAX_VALUE};
    }

    public static final String a(long j4, ag.e eVar) throws EOFException {
        if (j4 > 0) {
            long j7 = j4 - 1;
            if (eVar.s(j7) == 13) {
                String strJ = eVar.J(j7, ne.a.f9126a);
                eVar.skip(2L);
                return strJ;
            }
        }
        String strJ2 = eVar.J(j4, ne.a.f9126a);
        eVar.skip(1L);
        return strJ2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r18 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007e, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int b(ag.e r16, ag.m r17, boolean r18) {
        /*
            r0 = r17
            java.lang.String r1 = "options"
            ge.i.e(r0, r1)
            r1 = r16
            ag.r r1 = r1.f428v
            r2 = -1
            if (r1 != 0) goto L12
            if (r18 == 0) goto L11
            goto L5e
        L11:
            return r2
        L12:
            byte[] r3 = r1.f462a
            int r4 = r1.f463b
            int r5 = r1.f464c
            int[] r0 = r0.f447w
            r6 = 0
            r8 = r1
            r9 = r2
            r7 = r6
        L1e:
            int r10 = r7 + 1
            r11 = r0[r7]
            int r7 = r7 + 2
            r10 = r0[r10]
            if (r10 == r2) goto L29
            r9 = r10
        L29:
            if (r8 != 0) goto L2c
            goto L5c
        L2c:
            r10 = 0
            if (r11 >= 0) goto L74
            int r11 = r11 * (-1)
            int r12 = r11 + r7
        L33:
            int r11 = r4 + 1
            r4 = r3[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r13 = r7 + 1
            r7 = r0[r7]
            if (r4 == r7) goto L40
            goto L7e
        L40:
            if (r13 != r12) goto L44
            r4 = 1
            goto L45
        L44:
            r4 = r6
        L45:
            if (r11 != r5) goto L64
            ge.i.b(r8)
            ag.r r3 = r8.f
            ge.i.b(r3)
            int r5 = r3.f463b
            byte[] r7 = r3.f462a
            int r8 = r3.f464c
            if (r3 != r1) goto L60
            if (r4 == 0) goto L5c
            r3 = r7
            r7 = r10
            goto L67
        L5c:
            if (r18 == 0) goto L7e
        L5e:
            r0 = -2
            return r0
        L60:
            r15 = r7
            r7 = r3
            r3 = r15
            goto L67
        L64:
            r7 = r8
            r8 = r5
            r5 = r11
        L67:
            if (r4 == 0) goto L6f
            r4 = r0[r13]
            r15 = r8
            r8 = r7
            r7 = r15
            goto La0
        L6f:
            r4 = r5
            r5 = r8
            r8 = r7
            r7 = r13
            goto L33
        L74:
            int r12 = r4 + 1
            r4 = r3[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r13 = r7 + r11
        L7c:
            if (r7 != r13) goto L7f
        L7e:
            return r9
        L7f:
            r14 = r0[r7]
            if (r4 != r14) goto Laa
            int r7 = r7 + r11
            r4 = r0[r7]
            if (r12 != r5) goto L9e
            ag.r r8 = r8.f
            ge.i.b(r8)
            int r3 = r8.f463b
            byte[] r5 = r8.f462a
            int r7 = r8.f464c
            if (r8 != r1) goto L9a
            r8 = r5
            r5 = r3
            r3 = r8
            r8 = r10
            goto La0
        L9a:
            r15 = r5
            r5 = r3
            r3 = r15
            goto La0
        L9e:
            r7 = r5
            r5 = r12
        La0:
            if (r4 < 0) goto La3
            return r4
        La3:
            int r4 = -r4
            r15 = r7
            r7 = r4
            r4 = r5
            r5 = r15
            goto L1e
        Laa:
            int r7 = r7 + 1
            goto L7c
        */
        throw new UnsupportedOperationException("Method not decompiled: bg.a.b(ag.e, ag.m, boolean):int");
    }
}
