package f9;

import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.v7;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f4014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f4015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f4016e;
    public Long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f4018h;
    public final i5 i;

    public b(c cVar, String str, int i, i5 i5Var, int i10) {
        this.f4017g = i10;
        this.f4018h = cVar;
        this.f4012a = str;
        this.f4013b = i;
        this.i = i5Var;
    }

    public static Boolean c(Boolean bool, boolean z10) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z10);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Boolean d(String str, com.google.android.gms.internal.measurement.w1 w1Var, w0 w0Var) {
        List listU;
        o8.u.g(w1Var);
        if (str != null && w1Var.p() && w1Var.x() != 1 && (w1Var.x() != 7 ? w1Var.q() : w1Var.v() != 0)) {
            int iX = w1Var.x();
            boolean zT = w1Var.t();
            String strR = (zT || iX == 2 || iX == 7) ? w1Var.r() : w1Var.r().toUpperCase(Locale.ENGLISH);
            if (w1Var.v() == 0) {
                listU = null;
            } else {
                listU = w1Var.u();
                if (!zT) {
                    ArrayList arrayList = new ArrayList(listU.size());
                    Iterator it = listU.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                    }
                    listU = Collections.unmodifiableList(arrayList);
                }
            }
            String str2 = iX == 2 ? strR : null;
            if (iX != 7 ? strR != null : listU != null && !listU.isEmpty()) {
                if (!zT && iX != 2) {
                    str = str.toUpperCase(Locale.ENGLISH);
                }
                switch (iX - 1) {
                    case 1:
                        if (str2 != null) {
                            try {
                                return Boolean.valueOf(Pattern.compile(str2, true != zT ? 66 : 0).matcher(str).matches());
                            } catch (PatternSyntaxException unused) {
                                if (w0Var != null) {
                                    w0Var.E.b(str2, "Invalid regular expression in REGEXP audience filter. expression");
                                }
                            }
                        }
                        break;
                    case 2:
                        return Boolean.valueOf(str.startsWith(strR));
                    case 3:
                        return Boolean.valueOf(str.endsWith(strR));
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        return Boolean.valueOf(str.contains(strR));
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        return Boolean.valueOf(str.equals(strR));
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        if (listU != null) {
                            return Boolean.valueOf(listU.contains(str));
                        }
                        break;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Boolean e(java.math.BigDecimal r8, com.google.android.gms.internal.measurement.t1 r9, double r10) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.b.e(java.math.BigDecimal, com.google.android.gms.internal.measurement.t1, double):java.lang.Boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03c9 A[EDGE_INSN: B:234:0x03c9->B:161:0x03c9 BREAK  A[LOOP:3: B:89:0x0246->B:238:0x0246], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017c  */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.Long r22, java.lang.Long r23, com.google.android.gms.internal.measurement.b3 r24, long r25, f9.s r27, boolean r28) {
        /*
            Method dump skipped, instruction units count: 1085
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.b.a(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.b3, long, f9.s, boolean):boolean");
    }

    public boolean b(Long l10, Long l11, com.google.android.gms.internal.measurement.s3 s3Var, boolean z10) {
        boolean z11;
        Boolean boolC;
        Boolean boolE;
        Boolean boolE2;
        Boolean boolE3;
        v7.a();
        r1 r1Var = (r1) this.f4018h.f307w;
        g gVar = r1Var.f4366y;
        q0 q0Var = r1Var.E;
        w0 w0Var = r1Var.A;
        boolean zW1 = gVar.w1(this.f4012a, f0.E0);
        com.google.android.gms.internal.measurement.v1 v1Var = (com.google.android.gms.internal.measurement.v1) this.i;
        boolean zT = v1Var.t();
        boolean zU = v1Var.u();
        boolean zW = v1Var.w();
        boolean z12 = zT || zU || zW;
        if (z10 && !z12) {
            r1.g(w0Var);
            w0Var.J.c(Integer.valueOf(this.f4013b), v1Var.p() ? Integer.valueOf(v1Var.q()) : null, "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID");
            return true;
        }
        com.google.android.gms.internal.measurement.q1 q1VarS = v1Var.s();
        boolean zU2 = q1VarS.u();
        if (!s3Var.u()) {
            z11 = zW;
            if (!s3Var.y()) {
                if (!s3Var.s()) {
                    r1.g(w0Var);
                    w0Var.E.b(q0Var.c(s3Var.r()), "User property has no value, property");
                } else if (q1VarS.p()) {
                    String strT = s3Var.t();
                    com.google.android.gms.internal.measurement.w1 w1VarQ = q1VarS.q();
                    r1.g(w0Var);
                    boolC = c(d(strT, w1VarQ, w0Var), zU2);
                } else if (!q1VarS.r()) {
                    r1.g(w0Var);
                    w0Var.E.b(q0Var.c(s3Var.r()), "No string or number filter defined. property");
                } else if (a1.S1(s3Var.t())) {
                    String strT2 = s3Var.t();
                    com.google.android.gms.internal.measurement.t1 t1VarS = q1VarS.s();
                    if (a1.S1(strT2)) {
                        try {
                            boolE = e(new BigDecimal(strT2), t1VarS, 0.0d);
                        } catch (NumberFormatException unused) {
                            boolE = null;
                        }
                        boolC = c(boolE, zU2);
                    } else {
                        boolE = null;
                        boolC = c(boolE, zU2);
                    }
                } else {
                    r1.g(w0Var);
                    w0Var.E.c(q0Var.c(s3Var.r()), s3Var.t(), "Invalid user property value for Numeric number filter. property, value");
                }
                boolC = null;
            } else if (q1VarS.r()) {
                double dZ = s3Var.z();
                try {
                    boolE2 = e(new BigDecimal(dZ), q1VarS.s(), Math.ulp(dZ));
                } catch (NumberFormatException unused2) {
                    boolE2 = null;
                }
                boolC = c(boolE2, zU2);
            } else {
                r1.g(w0Var);
                w0Var.E.b(q0Var.c(s3Var.r()), "No number filter for double property. property");
                boolC = null;
            }
        } else if (q1VarS.r()) {
            z11 = zW;
            try {
                boolE3 = e(new BigDecimal(s3Var.v()), q1VarS.s(), 0.0d);
            } catch (NumberFormatException unused3) {
                boolE3 = null;
            }
            boolC = c(boolE3, zU2);
        } else {
            r1.g(w0Var);
            w0Var.E.b(q0Var.c(s3Var.r()), "No number filter for long property. property");
            z11 = zW;
            boolC = null;
        }
        r1.g(w0Var);
        w0Var.J.b(boolC == null ? "null" : boolC, "Property filter result");
        if (boolC == null) {
            return false;
        }
        this.f4014c = Boolean.TRUE;
        if (!z11 || boolC.booleanValue()) {
            if (!z10 || v1Var.t()) {
                this.f4015d = boolC;
            }
            if (boolC.booleanValue() && z12 && s3Var.p()) {
                long jQ = s3Var.q();
                if (l10 != null) {
                    jQ = l10.longValue();
                }
                if (zW1 && v1Var.t() && !v1Var.u() && l11 != null) {
                    jQ = l11.longValue();
                }
                if (v1Var.u()) {
                    this.f = Long.valueOf(jQ);
                } else {
                    this.f4016e = Long.valueOf(jQ);
                }
            }
        }
        return true;
    }
}
