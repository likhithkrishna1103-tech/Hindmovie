package l6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f7857c = new e("COMPOSITION");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f7859b;

    public e(String... strArr) {
        this.f7858a = Arrays.asList(strArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0088 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(int r8, java.lang.String r9) {
        /*
            r7 = this;
            java.util.List r0 = r7.f7858a
            int r1 = r0.size()
            r2 = 0
            if (r8 < r1) goto Lb
            goto L91
        Lb:
            int r1 = r0.size()
            r3 = 1
            int r1 = r1 - r3
            if (r8 != r1) goto L15
            r1 = r3
            goto L16
        L15:
            r1 = r2
        L16:
            java.lang.Object r4 = r0.get(r8)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "**"
            boolean r6 = r4.equals(r5)
            if (r6 != 0) goto L54
            boolean r9 = r4.equals(r9)
            if (r9 != 0) goto L35
            java.lang.String r9 = "*"
            boolean r9 = r4.equals(r9)
            if (r9 == 0) goto L33
            goto L35
        L33:
            r9 = r2
            goto L36
        L35:
            r9 = r3
        L36:
            if (r1 != 0) goto L51
            int r1 = r0.size()
            int r1 = r1 + (-2)
            if (r8 != r1) goto L91
            int r8 = r0.size()
            int r8 = r8 - r3
            java.lang.Object r8 = r0.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.equals(r5)
            if (r8 == 0) goto L91
        L51:
            if (r9 == 0) goto L91
            goto L88
        L54:
            if (r1 != 0) goto L86
            int r4 = r8 + 1
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r4.equals(r9)
            if (r4 == 0) goto L86
            int r9 = r0.size()
            int r9 = r9 + (-2)
            if (r8 == r9) goto L88
            int r9 = r0.size()
            int r9 = r9 + (-3)
            if (r8 != r9) goto L91
            int r8 = r0.size()
            int r8 = r8 - r3
            java.lang.Object r8 = r0.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.equals(r5)
            if (r8 == 0) goto L91
            goto L88
        L86:
            if (r1 == 0) goto L89
        L88:
            return r3
        L89:
            int r8 = r8 + r3
            int r1 = r0.size()
            int r1 = r1 - r3
            if (r8 >= r1) goto L92
        L91:
            return r2
        L92:
            java.lang.Object r8 = r0.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            boolean r8 = r8.equals(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.e.a(int, java.lang.String):boolean");
    }

    public final int b(int i, String str) {
        if ("__container".equals(str)) {
            return 0;
        }
        List list = this.f7858a;
        if (((String) list.get(i)).equals("**")) {
            return (i != list.size() - 1 && ((String) list.get(i + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public final boolean c(int i, String str) {
        if ("__container".equals(str)) {
            return true;
        }
        List list = this.f7858a;
        if (i >= list.size()) {
            return false;
        }
        return ((String) list.get(i)).equals(str) || ((String) list.get(i)).equals("**") || ((String) list.get(i)).equals("*");
    }

    public final boolean d(int i, String str) {
        if ("__container".equals(str)) {
            return true;
        }
        List list = this.f7858a;
        return i < list.size() - 1 || ((String) list.get(i)).equals("**");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (!this.f7858a.equals(eVar.f7858a)) {
                return false;
            }
            f fVar = this.f7859b;
            f fVar2 = eVar.f7859b;
            if (fVar != null) {
                return fVar.equals(fVar2);
            }
            if (fVar2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f7858a.hashCode() * 31;
        f fVar = this.f7859b;
        return iHashCode + (fVar != null ? fVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("KeyPath{keys=");
        sb.append(this.f7858a);
        sb.append(",resolved=");
        sb.append(this.f7859b != null);
        sb.append('}');
        return sb.toString();
    }

    public e(e eVar) {
        this.f7858a = new ArrayList(eVar.f7858a);
        this.f7859b = eVar.f7859b;
    }
}
