package w4;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.ActionMode;
import android.view.View;
import android.widget.TextView;
import app.cricfy.tv.app.IGlideModule;
import com.google.android.gms.internal.measurement.a5;
import java.lang.reflect.Field;
import java.net.ProtocolException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import o.a1;
import o.q3;
import o.s3;
import t0.r0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class v implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f13999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f14000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class f14001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f14002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Field f14003e;
    public static boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Field f14004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f14005h;

    public static final Object e(j9.p pVar, vc.v vVar) throws Exception {
        if (!pVar.i()) {
            pe.h hVar = new pe.h(1, u8.a.t(vVar));
            hVar.w();
            pVar.b(ye.a.f15053v, new m2.e(hVar));
            return hVar.v();
        }
        Exception excG = pVar.g();
        if (excG != null) {
            throw excG;
        }
        if (!pVar.f6709d) {
            return pVar.h();
        }
        throw new CancellationException("Task " + pVar + " was cancelled normally.");
    }

    public static byte[] f(b2.h hVar, String str, byte[] bArr, Map map) throws l2.a0 {
        Map map2;
        List list;
        b2.f0 f0Var = new b2.f0(hVar);
        Map map3 = Collections.EMPTY_MAP;
        Uri uri = Uri.parse(str);
        y1.d.i(uri, "The uri must be set.");
        b2.o oVar = new b2.o(uri, 0L, 2, bArr, map, 0L, -1L, null, 1);
        int i = 0;
        int i10 = 0;
        b2.o oVarA = oVar;
        while (true) {
            try {
                b2.m mVar = new b2.m(f0Var, oVarA);
                try {
                    byte[] bArrB = va.b.b(mVar);
                    y1.a0.g(mVar);
                    return bArrB;
                } catch (b2.a0 e9) {
                    try {
                        int i11 = e9.f1671y;
                        String str2 = null;
                        if ((i11 == 307 || i11 == 308) && i10 < 5 && (map2 = e9.f1672z) != null && (list = (List) map2.get("Location")) != null && !list.isEmpty()) {
                            str2 = (String) list.get(i);
                        }
                        if (str2 == null) {
                            throw e9;
                        }
                        i10++;
                        b2.n nVarA = oVarA.a();
                        nVarA.f1707a = Uri.parse(str2);
                        oVarA = nVarA.a();
                        y1.a0.g(mVar);
                    } catch (Throwable th) {
                        y1.a0.g(mVar);
                        throw th;
                    }
                }
            } catch (Exception e10) {
                throw new l2.a0(oVar, f0Var.f1686x, f0Var.f1684v.j(), f0Var.f1685w, e10);
            }
        }
    }

    public static void g(Object obj) {
        LongSparseArray longSparseArray;
        if (!f14002d) {
            try {
                f14001c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e9) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e9);
            }
            f14002d = true;
        }
        Class cls = f14001c;
        if (cls == null) {
            return;
        }
        if (!f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f14003e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e10);
            }
            f = true;
        }
        Field field = f14003e;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e11) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e11);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public static final le.b h(bf.d dVar) {
        ge.i.e(dVar, "<this>");
        if (dVar instanceof df.p) {
            return h(((df.p) dVar).f3728a);
        }
        return null;
    }

    public static r0.c i(a1 a1Var) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return new r0.c(j0.a.j(a1Var));
        }
        TextPaint textPaint = new TextPaint(a1Var.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = a1Var.getBreakStrategy();
        int hyphenationFrequency = a1Var.getHyphenationFrequency();
        if (a1Var.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i < 28 || (a1Var.getInputType() & 15) != 3) {
            boolean z10 = a1Var.getLayoutDirection() == 1;
            switch (a1Var.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case g1.h.LONG_FIELD_NUMBER /* 4 */:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case g1.h.STRING_FIELD_NUMBER /* 5 */:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                    break;
                case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z10) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(j0.a.a(p0.d.c(a1Var.getTextLocale()))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new r0.c(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static boolean k(Throwable th) {
        return Build.VERSION.SDK_INT == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/NotProvisionedException;.<init>(");
    }

    public static boolean l(Throwable th) {
        return Build.VERSION.SDK_INT == 34 && (th instanceof NoSuchMethodError) && th.getMessage() != null && th.getMessage().contains("Landroid/media/ResourceBusyException;.<init>(");
    }

    public static String n(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static f3.a o(String str) throws ProtocolException {
        int i;
        String strSubstring;
        ge.i.e(str, "statusLine");
        boolean Z = ne.o.Z(str, "HTTP/1.", false);
        kf.v vVar = kf.v.f7573x;
        kf.v vVar2 = kf.v.f7574y;
        if (Z) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                vVar = vVar2;
            }
        } else if (ne.o.Z(str, "ICY ", false)) {
            i = 4;
        } else {
            if (!ne.o.Z(str, "SOURCETABLE ", false)) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i = 12;
            vVar = vVar2;
        }
        int i10 = i + 3;
        if (str.length() < i10) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        String strSubstring2 = str.substring(i, i10);
        ge.i.d(strSubstring2, "substring(...)");
        Integer numA0 = ne.o.a0(strSubstring2);
        if (numA0 == null) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        int iIntValue = numA0.intValue();
        if (str.length() <= i10) {
            strSubstring = "";
        } else {
            if (str.charAt(i10) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            strSubstring = str.substring(i + 4);
            ge.i.d(strSubstring, "substring(...)");
        }
        return new f3.a(vVar, iIntValue, strSubstring, 8);
    }

    public static void q(TextView textView, int i) {
        com.bumptech.glide.f.e(i);
        if (Build.VERSION.SDK_INT >= 28) {
            j0.a.m(textView, i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i10 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i > Math.abs(i10)) {
            textView.setPadding(textView.getPaddingLeft(), i + i10, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void r(TextView textView, int i) {
        com.bumptech.glide.f.e(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i10 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i10)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i10);
        }
    }

    public static void s(TextView textView, int i) {
        com.bumptech.glide.f.e(i);
        if (i != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i - r0, 1.0f);
        }
    }

    public static void t(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            q3.a(view, charSequence);
            return;
        }
        s3 s3Var = s3.F;
        if (s3Var != null && s3Var.f9350v == view) {
            s3.b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new s3(view, charSequence);
            return;
        }
        s3 s3Var2 = s3.G;
        if (s3Var2 != null && s3Var2.f9350v == view) {
            s3Var2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static ActionMode.Callback v(ActionMode.Callback callback) {
        return (!(callback instanceof x0.h) || Build.VERSION.SDK_INT < 26) ? callback : ((x0.h) callback).f14220a;
    }

    public static ActionMode.Callback w(ActionMode.Callback callback, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof x0.h) || callback == null) ? callback : new x0.h(callback, textView);
    }

    public static String y(a5 a5Var) {
        StringBuilder sb = new StringBuilder(a5Var.c());
        for (int i = 0; i < a5Var.c(); i++) {
            byte bA = a5Var.a(i);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        sb.append("\\a");
                        break;
                    case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public abstract float j(ka.w wVar);

    public boolean m() {
        return !(this instanceof IGlideModule);
    }

    public abstract void u(ka.w wVar, float f10);

    public abstract void x(byte[] bArr, int i, int i10);

    @Override // t0.r0
    public void b() {
    }

    @Override // t0.r0
    public void c() {
    }

    public void d() {
    }

    public void p(Context context, com.bumptech.glide.b bVar, com.bumptech.glide.k kVar) {
    }
}
