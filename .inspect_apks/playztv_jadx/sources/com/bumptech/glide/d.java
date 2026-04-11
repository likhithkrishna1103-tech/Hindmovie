package com.bumptech.glide;

import a2.g1;
import a2.h0;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.media3.decoder.DecoderInputBuffer;
import c2.w;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import h4.z;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import n.d1;
import n.n2;
import org.json.JSONException;
import org.json.JSONObject;
import s1.t;
import ue.q;
import ue.u;
import ue.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f2769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f2770b;

    public static OkHttpGlideModule C(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                if (objNewInstance instanceof OkHttpGlideModule) {
                    return (OkHttpGlideModule) objNewInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
            } catch (IllegalAccessException e10) {
                V(cls, e10);
                throw null;
            } catch (InstantiationException e11) {
                V(cls, e11);
                throw null;
            } catch (NoSuchMethodException e12) {
                V(cls, e12);
                throw null;
            } catch (InvocationTargetException e13) {
                V(cls, e13);
                throw null;
            }
        } catch (ClassNotFoundException e14) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e14);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList D(s1.u r30) {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.d.D(s1.u):java.util.ArrayList");
    }

    public static void E(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            Animator animator = (Animator) arrayList.get(i);
            jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        arrayList.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(arrayList);
    }

    public static int F(t tVar, int i, int i10, int i11) {
        s1.d.b(Math.max(Math.max(i, i10), i11) <= 31);
        int i12 = (1 << i) - 1;
        int i13 = (1 << i10) - 1;
        android.support.v4.media.session.b.h(android.support.v4.media.session.b.h(i12, i13), 1 << i11);
        if (tVar.b() < i) {
            return -1;
        }
        int i14 = tVar.i(i);
        if (i14 == i12) {
            if (tVar.b() < i10) {
                return -1;
            }
            int i15 = tVar.i(i10);
            i14 += i15;
            if (i15 == i13) {
                if (tVar.b() < i11) {
                    return -1;
                }
                return tVar.i(i11) + i14;
            }
        }
        return i14;
    }

    public static void G(String str, pc.i iVar) {
        if (str.startsWith("https:////")) {
            str = str.replaceFirst("https:////", "https://");
        }
        if (str.endsWith("]")) {
            str = str.substring(0, str.length() - 1);
        }
        H(str, null, iVar);
    }

    public static void H(String str, HashMap map, pc.i iVar) {
        new Handler(Looper.getMainLooper()).post(new g1(str, iVar, map, 7));
    }

    public static void L(TextView textView, int i) {
        cf.l.h(i);
        if (Build.VERSION.SDK_INT >= 28) {
            g0.a.m(textView, i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i10 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i > Math.abs(i10)) {
            textView.setPadding(textView.getPaddingLeft(), i + i10, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void M(TextView textView, int i) {
        cf.l.h(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i10 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i10)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i10);
        }
    }

    public static void N(TextView textView, int i) {
        cf.l.h(i);
        if (i != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i - r0, 1.0f);
        }
    }

    public static void P(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void R(final Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z2, lc.b bVar, h0 h0Var) {
        h.f fVar = new h.f(context);
        View viewInflate = LayoutInflater.from(context).inflate(gc.k.dialog_add_playlist, (ViewGroup) null, false);
        int i = gc.j.login_ly;
        LinearLayout linearLayout = (LinearLayout) z7.a.k(viewInflate, i);
        if (linearLayout != null) {
            i = gc.j.pass_container;
            TextInputLayout textInputLayout = (TextInputLayout) z7.a.k(viewInflate, i);
            if (textInputLayout != null) {
                i = gc.j.password_input;
                TextInputEditText textInputEditText = (TextInputEditText) z7.a.k(viewInflate, i);
                if (textInputEditText != null) {
                    i = gc.j.path_input;
                    TextInputEditText textInputEditText2 = (TextInputEditText) z7.a.k(viewInflate, i);
                    if (textInputEditText2 != null) {
                        i = gc.j.path_input_container;
                        TextInputLayout textInputLayout2 = (TextInputLayout) z7.a.k(viewInflate, i);
                        if (textInputLayout2 != null) {
                            i = gc.j.title_container;
                            TextInputLayout textInputLayout3 = (TextInputLayout) z7.a.k(viewInflate, i);
                            if (textInputLayout3 != null) {
                                i = gc.j.title_input;
                                TextInputEditText textInputEditText3 = (TextInputEditText) z7.a.k(viewInflate, i);
                                if (textInputEditText3 != null) {
                                    i = gc.j.user_container;
                                    TextInputLayout textInputLayout4 = (TextInputLayout) z7.a.k(viewInflate, i);
                                    if (textInputLayout4 != null) {
                                        i = gc.j.username_input;
                                        TextInputEditText textInputEditText4 = (TextInputEditText) z7.a.k(viewInflate, i);
                                        if (textInputEditText4 != null) {
                                            ScrollView scrollView = (ScrollView) viewInflate;
                                            final zc.c cVar = new zc.c();
                                            cVar.f14945u = linearLayout;
                                            cVar.f14946v = textInputEditText;
                                            cVar.f14947w = textInputEditText2;
                                            cVar.f14948x = textInputEditText3;
                                            cVar.f14949y = textInputEditText4;
                                            if (str3 != null) {
                                                textInputEditText3.setText(str3);
                                                textInputEditText2.setText(str4);
                                                textInputEditText4.setText(str5);
                                                textInputEditText.setText(str6);
                                            }
                                            if (z2) {
                                                textInputLayout2.setHint("Enter Server:Port");
                                                linearLayout.setVisibility(0);
                                            }
                                            fVar.setView(scrollView);
                                            fVar.setTitle(str);
                                            fVar.a(str2, null);
                                            h.c cVar2 = fVar.f5489a;
                                            cVar2.i = "Cancel";
                                            cVar2.f5447j = null;
                                            if (h0Var != null) {
                                                hc.g gVar = new hc.g(2, h0Var);
                                                cVar2.f5448k = "Delete";
                                                cVar2.f5449l = gVar;
                                            }
                                            h.g gVarB = fVar.b();
                                            gVarB.A.i.setOnClickListener(new ic.a(cVar, gVarB, bVar, 2));
                                            final int i10 = 0;
                                            textInputLayout3.setEndIconOnClickListener(new View.OnClickListener() { // from class: lc.a
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    switch (i10) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((TextInputEditText) cVar.f14948x).setText(uc.b.i(context));
                                                            break;
                                                        case 1:
                                                            ((TextInputEditText) cVar.f14947w).setText(uc.b.i(context));
                                                            break;
                                                        case 2:
                                                            ((TextInputEditText) cVar.f14949y).setText(uc.b.i(context));
                                                            break;
                                                        default:
                                                            ((TextInputEditText) cVar.f14946v).setText(uc.b.i(context));
                                                            break;
                                                    }
                                                }
                                            });
                                            final int i11 = 1;
                                            textInputLayout2.setEndIconOnClickListener(new View.OnClickListener() { // from class: lc.a
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    switch (i11) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((TextInputEditText) cVar.f14948x).setText(uc.b.i(context));
                                                            break;
                                                        case 1:
                                                            ((TextInputEditText) cVar.f14947w).setText(uc.b.i(context));
                                                            break;
                                                        case 2:
                                                            ((TextInputEditText) cVar.f14949y).setText(uc.b.i(context));
                                                            break;
                                                        default:
                                                            ((TextInputEditText) cVar.f14946v).setText(uc.b.i(context));
                                                            break;
                                                    }
                                                }
                                            });
                                            final int i12 = 2;
                                            textInputLayout4.setEndIconOnClickListener(new View.OnClickListener() { // from class: lc.a
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    switch (i12) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((TextInputEditText) cVar.f14948x).setText(uc.b.i(context));
                                                            break;
                                                        case 1:
                                                            ((TextInputEditText) cVar.f14947w).setText(uc.b.i(context));
                                                            break;
                                                        case 2:
                                                            ((TextInputEditText) cVar.f14949y).setText(uc.b.i(context));
                                                            break;
                                                        default:
                                                            ((TextInputEditText) cVar.f14946v).setText(uc.b.i(context));
                                                            break;
                                                    }
                                                }
                                            });
                                            final int i13 = 3;
                                            textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: lc.a
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    switch (i13) {
                                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                                            ((TextInputEditText) cVar.f14948x).setText(uc.b.i(context));
                                                            break;
                                                        case 1:
                                                            ((TextInputEditText) cVar.f14947w).setText(uc.b.i(context));
                                                            break;
                                                        case 2:
                                                            ((TextInputEditText) cVar.f14949y).setText(uc.b.i(context));
                                                            break;
                                                        default:
                                                            ((TextInputEditText) cVar.f14946v).setText(uc.b.i(context));
                                                            break;
                                                    }
                                                }
                                            });
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static void S(t tVar) {
        tVar.t(3);
        tVar.t(8);
        boolean zH = tVar.h();
        boolean zH2 = tVar.h();
        if (zH) {
            tVar.t(5);
        }
        if (zH2) {
            tVar.t(6);
        }
    }

    public static void T(t tVar) {
        int i;
        int i10 = tVar.i(2);
        if (i10 == 0) {
            tVar.t(6);
            return;
        }
        int iF = F(tVar, 5, 8, 16) + 1;
        if (i10 == 1) {
            tVar.t(iF * 7);
            return;
        }
        if (i10 == 2) {
            boolean zH = tVar.h();
            int i11 = zH ? 1 : 5;
            int i12 = zH ? 7 : 5;
            int i13 = zH ? 8 : 6;
            int i14 = 0;
            while (i14 < iF) {
                if (tVar.h()) {
                    tVar.t(7);
                    i = 0;
                } else {
                    if (tVar.i(2) == 3 && tVar.i(i12) * i11 != 0) {
                        tVar.s();
                    }
                    i = tVar.i(i13) * i11;
                    if (i != 0 && i != 180) {
                        tVar.s();
                    }
                    tVar.s();
                }
                if (i != 0 && i != 180 && tVar.h()) {
                    i14++;
                }
                i14++;
            }
        }
    }

    public static void V(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, reflectiveOperationException);
    }

    public static int W(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static String X(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c9 = charArray[i];
                    if (c9 >= 'A' && c9 <= 'Z') {
                        charArray[i] = (char) (c9 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static String Y(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'a' && cCharAt <= 'z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c9 = charArray[i];
                    if (c9 >= 'a' && c9 <= 'z') {
                        charArray[i] = (char) (c9 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static ActionMode.Callback Z(ActionMode.Callback callback) {
        return (!(callback instanceof u0.h) || Build.VERSION.SDK_INT < 26) ? callback : ((u0.h) callback).f12538a;
    }

    public static boolean a(String str, String str2) {
        String host;
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str2);
        if ((!fileExtensionFromUrl.equals("php") || !str2.contains(".m3u8")) && !fileExtensionFromUrl.equals("m3u8") && !fileExtensionFromUrl.equals("mpd") && !fileExtensionFromUrl.equals("ts") && !fileExtensionFromUrl.equals("mp4") && !fileExtensionFromUrl.equals("webm") && !fileExtensionFromUrl.equals("mkv")) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                host = new URI(str2).getHost();
                if (host != null && host.startsWith("www.")) {
                    host = host.substring(4);
                }
            } catch (URISyntaxException unused) {
                host = null;
            }
            if (!str.equals(host)) {
                return false;
            }
        }
        return true;
    }

    public static ActionMode.Callback a0(ActionMode.Callback callback, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof u0.h) || callback == null) ? callback : new u0.h(callback, textView);
    }

    public static float b(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float c(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static void d(Throwable th, Throwable th2) {
        be.h.e(th, "<this>");
        be.h.e(th2, "exception");
        if (th != th2) {
            Integer num = vd.a.f13494a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = ud.a.f12922a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static void e(String str) {
        if (str.length() > 127) {
            str = str.substring(0, ModuleDescriptor.MODULE_VERSION);
        }
        Trace.beginSection(str);
    }

    public static String h(String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            Charset charset = StandardCharsets.UTF_8;
            cipher.init(2, new SecretKeySpec("l2K5wB8xC1wP7rK1".getBytes(charset), "AES"), new IvParameterSpec("n0K4nP8uB8hH1l18".getBytes(charset)));
            return new String(cipher.doFinal(Base64.decode(str, 0)), charset);
        } catch (Exception e10) {
            e10.printStackTrace();
            return e10.getMessage();
        }
    }

    public static boolean j(String str, String str2) {
        char c9;
        int length = str.length();
        if (str == str2) {
            return true;
        }
        if (length == str2.length()) {
            for (int i = 0; i < length; i++) {
                if (str.charAt(i) == str2.charAt(i) || ((c9 = (char) ((r3 | ' ') - 97)) < 26 && c9 == ((char) ((r4 | ' ') - 97)))) {
                }
            }
            return true;
        }
        return false;
    }

    public static int k(float f, int i, int i10) {
        if (i == i10 || f <= 0.0f) {
            return i;
        }
        if (f >= 1.0f) {
            return i10;
        }
        float f4 = ((i >> 24) & 255) / 255.0f;
        float f10 = ((i10 >> 24) & 255) / 255.0f;
        float fB = b(((i >> 16) & 255) / 255.0f);
        float fB2 = b(((i >> 8) & 255) / 255.0f);
        float fB3 = b((i & 255) / 255.0f);
        float fB4 = b(((i10 >> 16) & 255) / 255.0f);
        float fB5 = b(((i10 >> 8) & 255) / 255.0f);
        float fB6 = b((i10 & 255) / 255.0f);
        float fG = e6.j.g(f10, f4, f, f4);
        float fG2 = e6.j.g(fB4, fB, f, fB);
        float fG3 = e6.j.g(fB5, fB2, f, fB2);
        float fG4 = e6.j.g(fB6, fB3, f, fB3);
        float fC = c(fG2) * 255.0f;
        float fC2 = c(fG3) * 255.0f;
        return Math.round(c(fG4) * 255.0f) | (Math.round(fC) << 16) | (Math.round(fG * 255.0f) << 24) | (Math.round(fC2) << 8);
    }

    public static void l(String str, pc.i iVar) {
        Matcher matcher = Pattern.compile("player\\.load\\(\\{[^}]*source:\\s*([a-zA-Z0-9_]+)\\(\\)").matcher(str);
        if (!matcher.find()) {
            H("http://error.com", null, iVar);
            return;
        }
        String strGroup = matcher.group(1);
        if (strGroup.contains("://")) {
            G(strGroup, iVar);
            return;
        }
        Matcher matcher2 = Pattern.compile("function\\s+" + Pattern.quote(strGroup) + "\\s*\\(\\)\\s*\\{([\\s\\S]*?)\\}").matcher(str);
        if (!matcher2.find()) {
            H("http://error.com", null, iVar);
            return;
        }
        String[] strArrSplit = matcher2.group(1).split("\\[")[1].split("\\.join")[0].split("\",\"|\"");
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArrSplit) {
            String strTrim = str2.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.startsWith("\"") && strTrim.endsWith("\"")) {
                    strTrim = strTrim.substring(1, strTrim.length() - 1);
                }
                sb2.append(strTrim.replace("\\/", "/"));
            }
        }
        G(sb2.toString(), iVar);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [pc.i] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v14, types: [pc.i] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v8, types: [pc.i] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    public static void m(Context context, String str, pc.i iVar) {
        ?? r11;
        ?? r112;
        String str2;
        HashMap mapQ;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url", null);
            String strOptString2 = jSONObject.optString("api", null);
            String strOptString3 = jSONObject.optString("type", "token");
            final String strOptString4 = jSONObject.optString("link_key", "playback_url");
            String strOptString5 = jSONObject.optString("default_string", "9HY(#b1q6");
            String strOptString6 = jSONObject.optString("request_type", "get");
            String strOptString7 = jSONObject.optString("request_body_type", "normal");
            String strOptString8 = jSONObject.optString("request_body", null);
            String strOptString9 = jSONObject.optString("ip_api", null);
            HashMap map = new HashMap();
            if ("daddy".equals(strOptString3)) {
                if (strOptString.contains("|")) {
                    String[] strArrSplit = strOptString.split("\\|");
                    str2 = strArrSplit[0];
                    mapQ = q(strArrSplit[1]);
                } else {
                    str2 = strOptString;
                    mapQ = map;
                }
                String[] strArrSplit2 = strOptString2.split("\\|");
                String str3 = strArrSplit2[0];
                String strB = qc.a.b(strArrSplit2[1]);
                ue.m mVarR = r(mapQ);
                ga.b.D(null, str2, false, null, mVarR, new pc.c(strOptString, str3, strB, mVarR, iVar, 0));
            }
            ?? Q = map;
            if (strOptString2.contains("|")) {
                String[] strArrSplit3 = strOptString2.split("\\|");
                String str4 = strArrSplit3[0];
                Q = q(strArrSplit3[1]);
                strOptString2 = str4;
            }
            try {
                switch (strOptString3.hashCode()) {
                    case 3463:
                        ?? r02 = Q;
                        pc.i iVar2 = iVar;
                        r112 = iVar2;
                        if (strOptString3.equals("ls")) {
                            if (strOptString9 == null) {
                                strOptString9 = new String(Base64.decode("aHR0cHM6Ly9pcC1hcGkuc3RyZWFtaW5ndWNtcy5jb20v", 0));
                            }
                            String str5 = strOptString9;
                            boolean zEquals = "post".equals(strOptString6);
                            ga.b.D(null, str5, zEquals, zEquals ? s(strOptString7, strOptString8) : null, r(r02), new pc.f(iVar2, strOptString2, strOptString5, r02));
                        }
                        r112.l("https://invalid_type", null);
                        break;
                    case 3677:
                        final ?? r03 = Q;
                        final pc.i iVar3 = iVar;
                        r112 = iVar3;
                        if (strOptString3.equals("sp")) {
                            boolean zEquals2 = "post".equals(strOptString6);
                            final int i = 0;
                            ga.b.D(null, strOptString2, zEquals2, zEquals2 ? s(strOptString7, strOptString8) : null, r(r03), new pc.l() { // from class: pc.e
                                @Override // pc.l
                                public final void f(String str6, boolean z2) throws JSONException {
                                    String string;
                                    String string2;
                                    switch (i) {
                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                            String str7 = strOptString4;
                                            i iVar4 = iVar3;
                                            if (z2) {
                                                try {
                                                    string = new JSONObject(str6).getString(str7);
                                                } catch (JSONException unused) {
                                                    string = null;
                                                }
                                                if (string == null) {
                                                    try {
                                                        String[] strArrSplit4 = new String(Base64.decode(new StringBuilder(str6).reverse().toString(), 0)).split("\\|", 2);
                                                        int i10 = Integer.parseInt(strArrSplit4[0]);
                                                        String str8 = strArrSplit4[1];
                                                        StringBuilder sb2 = new StringBuilder();
                                                        for (char c9 : str8.toCharArray()) {
                                                            if (Character.isLetter(c9)) {
                                                                char c10 = Character.isUpperCase(c9) ? 'A' : 'a';
                                                                sb2.append((char) (((((c9 - c10) - i10) + 26) % 26) + c10));
                                                            } else {
                                                                sb2.append(c9);
                                                            }
                                                        }
                                                        try {
                                                            string = new JSONObject(sb2.toString()).getString(str7);
                                                        } catch (JSONException unused2) {
                                                            string = null;
                                                        }
                                                        if (string == null) {
                                                            string = "https://error";
                                                        }
                                                    } catch (Exception e10) {
                                                        string = "https://" + e10.getMessage();
                                                    }
                                                }
                                                iVar4.l(string, string.contains("|") ? null : r03);
                                            } else {
                                                iVar4.l("http://error", null);
                                            }
                                            break;
                                        default:
                                            String str9 = strOptString4;
                                            i iVar5 = iVar3;
                                            if (z2) {
                                                try {
                                                    string2 = new JSONObject(str6).getString(str9);
                                                } catch (JSONException unused3) {
                                                    string2 = null;
                                                }
                                                if (string2 == null) {
                                                    iVar5.l("https://error", null);
                                                } else {
                                                    iVar5.l(string2, string2.contains("|") ? null : r03);
                                                }
                                            } else {
                                                iVar5.l("http://error", null);
                                            }
                                            break;
                                    }
                                }
                            });
                        }
                        r112.l("https://invalid_type", null);
                        break;
                    case 3867:
                        Q = iVar;
                        r112 = Q;
                        if (strOptString3.equals("yt")) {
                            try {
                                ArrayList arrayList = new ArrayList(20);
                                v.a("user-agent");
                                v.b("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36", "user-agent");
                                arrayList.add("user-agent");
                                arrayList.add(ie.e.b0("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").toString());
                                ga.b.D(null, strOptString2, false, null, new ue.m((String[]) arrayList.toArray(new String[0])), new pc.d(Q, 1));
                            } catch (Exception unused) {
                                Q.l("https://error.m3u8", null);
                                return;
                            }
                        }
                        r112.l("https://invalid_type", null);
                        break;
                    case 3213227:
                        ?? r04 = Q;
                        pc.i iVar4 = iVar;
                        r112 = iVar4;
                        if (strOptString3.equals("html")) {
                            Executors.newSingleThreadScheduledExecutor().execute(new g1(strOptString2, r04, iVar4, 6));
                        }
                        r112.l("https://invalid_type", null);
                        break;
                    case 3271912:
                        final ?? r05 = Q;
                        final pc.i iVar5 = iVar;
                        r112 = iVar5;
                        if (strOptString3.equals("json")) {
                            boolean zEquals3 = "post".equals(strOptString6);
                            final int i10 = 1;
                            ga.b.D(null, strOptString2, zEquals3, zEquals3 ? s(strOptString7, strOptString8) : null, r(r05), new pc.l() { // from class: pc.e
                                @Override // pc.l
                                public final void f(String str6, boolean z2) throws JSONException {
                                    String string;
                                    String string2;
                                    switch (i10) {
                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                            String str7 = strOptString4;
                                            i iVar42 = iVar5;
                                            if (z2) {
                                                try {
                                                    string = new JSONObject(str6).getString(str7);
                                                } catch (JSONException unused2) {
                                                    string = null;
                                                }
                                                if (string == null) {
                                                    try {
                                                        String[] strArrSplit4 = new String(Base64.decode(new StringBuilder(str6).reverse().toString(), 0)).split("\\|", 2);
                                                        int i102 = Integer.parseInt(strArrSplit4[0]);
                                                        String str8 = strArrSplit4[1];
                                                        StringBuilder sb2 = new StringBuilder();
                                                        for (char c9 : str8.toCharArray()) {
                                                            if (Character.isLetter(c9)) {
                                                                char c10 = Character.isUpperCase(c9) ? 'A' : 'a';
                                                                sb2.append((char) (((((c9 - c10) - i102) + 26) % 26) + c10));
                                                            } else {
                                                                sb2.append(c9);
                                                            }
                                                        }
                                                        try {
                                                            string = new JSONObject(sb2.toString()).getString(str7);
                                                        } catch (JSONException unused22) {
                                                            string = null;
                                                        }
                                                        if (string == null) {
                                                            string = "https://error";
                                                        }
                                                    } catch (Exception e10) {
                                                        string = "https://" + e10.getMessage();
                                                    }
                                                }
                                                iVar42.l(string, string.contains("|") ? null : r05);
                                            } else {
                                                iVar42.l("http://error", null);
                                            }
                                            break;
                                        default:
                                            String str9 = strOptString4;
                                            i iVar52 = iVar5;
                                            if (z2) {
                                                try {
                                                    string2 = new JSONObject(str6).getString(str9);
                                                } catch (JSONException unused3) {
                                                    string2 = null;
                                                }
                                                if (string2 == null) {
                                                    iVar52.l("https://error", null);
                                                } else {
                                                    iVar52.l(string2, string2.contains("|") ? null : r05);
                                                }
                                            } else {
                                                iVar52.l("http://error", null);
                                            }
                                            break;
                                    }
                                }
                            });
                        }
                        r112.l("https://invalid_type", null);
                        break;
                    case 96620249:
                        ?? r06 = Q;
                        pc.i iVar6 = iVar;
                        r112 = iVar6;
                        if (strOptString3.equals("embed")) {
                            n(context, strOptString, strOptString2, r06, iVar6);
                        }
                        r112.l("https://invalid_type", null);
                        break;
                    case 110541305:
                        if (strOptString3.equals("token")) {
                            try {
                                Executors.newSingleThreadScheduledExecutor().execute(new w(strOptString2, Q, strOptString, iVar, 9));
                            } catch (JSONException e10) {
                                e = e10;
                                r11 = iVar;
                                r11.l("https://" + e.getMessage(), null);
                                return;
                            }
                            break;
                        }
                    default:
                        r112 = iVar;
                        r112.l("https://invalid_type", null);
                        break;
                }
            } catch (JSONException e11) {
                e = e11;
                r11 = Q;
            }
        } catch (JSONException e12) {
            e = e12;
            r11 = iVar;
        }
    }

    public static void n(Context context, String str, String str2, HashMap map, pc.i iVar) {
        WebView webView = new WebView(context);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setMixedContentMode(0);
        settings.setMediaPlaybackRequiresUserGesture(false);
        webView.setWebViewClient(new pc.g(str, iVar));
        webView.setWebChromeClient(new pc.h());
        webView.loadUrl(str2, map);
    }

    public static Drawable p(Context context, int i) {
        return n2.d().f(context, i);
    }

    public static HashMap q(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("\\&")) {
            String[] strArrSplit = str2.split("\\=");
            if (strArrSplit.length != 1) {
                String str3 = strArrSplit[1];
                if (strArrSplit.length > 2) {
                    for (int i = 2; strArrSplit.length != i; i++) {
                        str3 = str3 + "=" + strArrSplit[i];
                    }
                }
                if (strArrSplit[0].equalsIgnoreCase("user-agent")) {
                    map.put("User-Agent", str3);
                } else {
                    map.put(strArrSplit[0], str3);
                }
            } else if (strArrSplit[0].equalsIgnoreCase("user-agent")) {
                map.put("User-Agent", "");
            } else {
                map.put(strArrSplit[0], "");
            }
        }
        return map;
    }

    public static ue.m r(HashMap map) {
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(20);
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            be.h.e(str, "name");
            be.h.e(str2, "value");
            v.a(str);
            v.b(str2, str);
            arrayList.add(str);
            arrayList.add(ie.e.b0(str2).toString());
        }
        return new ue.m((String[]) arrayList.toArray(new String[0]));
    }

    public static u s(String str, String str2) {
        q qVarI;
        q qVarI2 = null;
        if ("json".equals(str)) {
            if (str2 != null && !str2.isEmpty()) {
                Pattern pattern = q.f13015c;
                try {
                    qVarI = v.i("application/json; charset=utf-8");
                } catch (IllegalArgumentException unused) {
                    qVarI = null;
                }
                Charset charset = ie.a.f6599a;
                if (qVarI != null) {
                    Charset charsetA = qVarI.a(null);
                    if (charsetA == null) {
                        String str3 = qVarI + "; charset=utf-8";
                        be.h.e(str3, "<this>");
                        try {
                            qVarI2 = v.i(str3);
                        } catch (IllegalArgumentException unused2) {
                        }
                        qVarI = qVarI2;
                    } else {
                        charset = charsetA;
                    }
                }
                byte[] bytes = str2.getBytes(charset);
                be.h.d(bytes, "this as java.lang.String).getBytes(charset)");
                int length = bytes.length;
                ve.b.b(bytes.length, 0, length);
                return new u(qVarI, length, bytes);
            }
        } else if (str2 != null && !str2.isEmpty()) {
            return v.e(str2.getBytes());
        }
        return null;
    }

    public static o0.d t(d1 d1Var) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return new o0.d(g0.a.j(d1Var));
        }
        TextPaint textPaint = new TextPaint(d1Var.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = d1Var.getBreakStrategy();
        int hyphenationFrequency = d1Var.getHyphenationFrequency();
        if (d1Var.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i < 28 || (d1Var.getInputType() & 15) != 3) {
            boolean z2 = d1Var.getLayoutDirection() == 1;
            switch (d1Var.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z2) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(g0.a.a(m0.d.b(d1Var.getTextLocale()))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new o0.d(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static boolean w() {
        if (Build.VERSION.SDK_INT >= 29) {
            return f5.a.a();
        }
        try {
            if (f2770b == null) {
                f2769a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f2770b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f2770b.invoke(null, Long.valueOf(f2769a))).booleanValue();
        } catch (Exception e10) {
            if (!(e10 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e10);
                return false;
            }
            Throwable cause = e10.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public boolean A(KeyEvent keyEvent) {
        return false;
    }

    public boolean B() {
        return false;
    }

    public abstract void I(boolean z2);

    public abstract void J(boolean z2);

    public abstract void K();

    public abstract void O(boolean z2);

    public abstract void Q(CharSequence charSequence);

    public l.a U(z zVar) {
        return null;
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public abstract void i(boolean z2);

    public abstract int o();

    public abstract Context u();

    public boolean v() {
        return false;
    }

    public abstract void x();

    public abstract boolean z(int i, KeyEvent keyEvent);

    public void y() {
    }
}
