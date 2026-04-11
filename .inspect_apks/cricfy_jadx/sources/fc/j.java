package fc;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.internal.measurement.z3;
import df.l;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import pe.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h1.e f4556b = new h1.e("fire-global");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h1.e f4557c = new h1.e("fire-count");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h1.e f4558d = new h1.e("last-used-date");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xb.c f4559a;

    public j(Context context, String str) {
        this.f4559a = new xb.c(context, q4.a.n("FirebaseHeartBeat", str));
    }

    public final synchronized long a(h1.b bVar) {
        long j4;
        try {
            long jLongValue = ((Long) z3.l(bVar, f4557c, 0L)).longValue();
            String str = "";
            Set hashSet = new HashSet();
            String str2 = null;
            for (Map.Entry entry : bVar.a().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set<String> set = (Set) entry.getValue();
                    for (String str3 : set) {
                        if (str2 == null || str2.compareTo(str3) > 0) {
                            str = ((h1.e) entry.getKey()).f5477a;
                            hashSet = set;
                            str2 = str3;
                        }
                    }
                }
            }
            HashSet hashSet2 = new HashSet(hashSet);
            hashSet2.remove(str2);
            bVar.e(w8.e.m(str), hashSet2);
            j4 = jLongValue - 1;
            bVar.d(f4557c, Long.valueOf(j4));
        } catch (Throwable th) {
            throw th;
        }
        return j4;
    }

    public final synchronized void b() {
        this.f4559a.a(new l(1, this));
    }

    public final synchronized ArrayList c() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            String strD = d(System.currentTimeMillis());
            xb.c cVar = this.f4559a;
            cVar.getClass();
            for (Map.Entry entry : ((Map) x.o(vd.i.f13722v, new r4.a(cVar, null, 2))).entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(strD);
                    if (!hashSet.isEmpty()) {
                        arrayList.add(new a(((h1.e) entry.getKey()).f5477a, new ArrayList(hashSet)));
                    }
                }
            }
            l(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized String d(long j4) {
        if (Build.VERSION.SDK_INT < 26) {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j4));
        }
        Instant instant = new Date(j4).toInstant();
        ZoneOffset unused = ZoneOffset.UTC;
        LocalDateTime localDateTime = instant.atOffset(ZoneOffset.UTC).toLocalDateTime();
        DateTimeFormatter unused2 = DateTimeFormatter.ISO_LOCAL_DATE;
        return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public final synchronized h1.e e(h1.b bVar, String str) {
        for (Map.Entry entry : bVar.a().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return w8.e.m(((h1.e) entry.getKey()).f5477a);
                    }
                }
            }
        }
        return null;
    }

    public final synchronized boolean f(long j4, long j7) {
        return d(j4).equals(d(j7));
    }

    public final synchronized void g() {
        this.f4559a.a(new b6.c(3, this, d(System.currentTimeMillis())));
    }

    public final synchronized void h(h1.b bVar, String str) {
        try {
            h1.e eVarE = e(bVar, str);
            if (eVarE == null) {
                return;
            }
            HashSet hashSet = new HashSet((Collection) z3.l(bVar, eVarE, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                bVar.c(eVarE);
            } else {
                bVar.e(eVarE, hashSet);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean i(long j4) {
        return j(f4556b, j4);
    }

    public final synchronized boolean j(h1.e eVar, long j4) {
        xb.c cVar = this.f4559a;
        cVar.getClass();
        ge.i.e(eVar, "key");
        vd.c cVar2 = null;
        d1.e eVar2 = new d1.e(cVar, eVar, cVar2, 14);
        vd.i iVar = vd.i.f13722v;
        if (f(((Long) x.o(iVar, eVar2)).longValue(), j4)) {
            return false;
        }
        xb.c cVar3 = this.f4559a;
        Long lValueOf = Long.valueOf(j4);
        cVar3.getClass();
        return true;
    }

    public final synchronized void k(final String str, long j4) {
        final String strD = d(j4);
        final h1.e eVarM = w8.e.m(str);
        this.f4559a.a(new fe.l() { // from class: fc.h
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // fe.l
            public final Object a(Object obj) {
                j jVar = this.f4551v;
                String str2 = strD;
                String str3 = str;
                h1.e eVar = eVarM;
                h1.b bVar = (h1.b) obj;
                jVar.getClass();
                h1.e eVar2 = j.f4558d;
                if (((String) z3.l(bVar, eVar2, "")).equals(str2)) {
                    h1.e eVarE = jVar.e(bVar, str2);
                    if (eVarE == null || eVarE.f5477a.equals(str3)) {
                        return null;
                    }
                    synchronized (jVar) {
                        jVar.h(bVar, str2);
                        HashSet hashSet = new HashSet((Collection) z3.l(bVar, eVar, new HashSet()));
                        hashSet.add(str2);
                        bVar.e(eVar, hashSet);
                    }
                    return null;
                }
                h1.e eVar3 = j.f4557c;
                long jLongValue = ((Long) z3.l(bVar, eVar3, 0L)).longValue();
                if (jLongValue + 1 == 30) {
                    jLongValue = jVar.a(bVar);
                }
                HashSet hashSet2 = new HashSet((Collection) z3.l(bVar, eVar, new HashSet()));
                hashSet2.add(str2);
                bVar.e(eVar, hashSet2);
                bVar.e(eVar3, Long.valueOf(jLongValue + 1));
                bVar.e(eVar2, str2);
                return null;
            }
        });
    }

    public final synchronized void l(final long j4) {
        this.f4559a.a(new fe.l() { // from class: fc.i
            @Override // fe.l
            public final Object a(Object obj) {
                ((h1.b) obj).d(j.f4556b, Long.valueOf(j4));
                return null;
            }
        });
    }
}
