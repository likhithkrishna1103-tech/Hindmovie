package f1;

import android.content.Context;
import d1.q;
import g1.i;
import java.util.LinkedHashSet;
import java.util.Set;
import rd.j;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f3921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f3922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f3923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f3925e;
    public final Set f;

    public d(Context context, String str, Set set, q qVar, i iVar) {
        ge.i.e(context, "context");
        ge.i.e(str, "sharedPreferencesName");
        ge.i.e(set, "keysToMigrate");
        a aVar = new a(context, str, 0);
        this.f3921a = qVar;
        this.f3922b = iVar;
        this.f3923c = context;
        this.f3924d = str;
        this.f3925e = new j(aVar);
        this.f = set == e.f3926a ? null : new LinkedHashSet(set);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r5, xd.c r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof f1.c
            if (r0 == 0) goto L13
            r0 = r6
            f1.c r0 = (f1.c) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            f1.c r0 = new f1.c
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f3920z
            int r1 = r0.B
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            f1.d r5 = r0.f3919y
            com.bumptech.glide.c.C(r6)
            goto L42
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            com.bumptech.glide.c.C(r6)
            r0.f3919y = r4
            r0.B = r2
            d1.q r6 = r4.f3921a
            java.lang.Object r6 = r6.j(r5, r0)
            wd.a r5 = wd.a.f14143v
            if (r6 != r5) goto L41
            return r5
        L41:
            r5 = r4
        L42:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L4d
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            return r5
        L4d:
            java.util.Set r6 = r5.f
            rd.j r5 = r5.f3925e
            r0 = 0
            if (r6 != 0) goto L6c
            java.lang.Object r5 = r5.getValue()
            android.content.SharedPreferences r5 = (android.content.SharedPreferences) r5
            java.util.Map r5 = r5.getAll()
            java.lang.String r6 = "sharedPrefs.all"
            ge.i.d(r5, r6)
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L6a
            goto L8f
        L6a:
            r2 = r0
            goto L8f
        L6c:
            java.lang.Object r5 = r5.getValue()
            android.content.SharedPreferences r5 = (android.content.SharedPreferences) r5
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L79
            goto L6a
        L79:
            java.util.Iterator r6 = r6.iterator()
        L7d:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L6a
            java.lang.Object r1 = r6.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = r5.contains(r1)
            if (r1 == 0) goto L7d
        L8f:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.d.a(java.lang.Object, xd.c):java.lang.Object");
    }
}
