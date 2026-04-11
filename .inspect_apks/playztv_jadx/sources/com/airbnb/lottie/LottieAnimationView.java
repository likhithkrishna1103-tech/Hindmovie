package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import b8.j;
import com.airbnb.lottie.LottieAnimationView;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import l5.a;
import l5.a0;
import l5.b;
import l5.c0;
import l5.d0;
import l5.e;
import l5.e0;
import l5.f0;
import l5.g0;
import l5.h;
import l5.h0;
import l5.i;
import l5.i0;
import l5.k;
import l5.n;
import l5.r;
import l5.v;
import l5.w;
import l5.z;
import n.y;
import p2.c;
import x5.d;
import x5.f;
import x5.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends y {
    public static final e K = new e();
    public int A;
    public final w B;
    public String C;
    public int D;
    public boolean E;
    public boolean F;
    public boolean G;
    public final HashSet H;
    public final HashSet I;
    public c0 J;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final i f2755x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final i f2756y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public l5.y f2757z;

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        String string;
        super(context, attributeSet, 0);
        this.f2755x = new i(this, 1);
        this.f2756y = new i(this, 0);
        this.A = 0;
        w wVar = new w();
        this.B = wVar;
        this.E = false;
        this.F = false;
        this.G = true;
        HashSet hashSet = new HashSet();
        this.H = hashSet;
        this.I = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f0.LottieAnimationView, e0.lottieAnimationViewStyle, 0);
        this.G = typedArrayObtainStyledAttributes.getBoolean(f0.LottieAnimationView_lottie_cacheComposition, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_rawRes);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_fileName);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_url);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(f0.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(f0.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(f0.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(f0.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(f0.LottieAnimationView_lottie_autoPlay, false)) {
            this.F = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(f0.LottieAnimationView_lottie_loop, false)) {
            wVar.f7919v.setRepeatCount(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(f0.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(f0.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(f0.LottieAnimationView_lottie_speed, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_clipToCompositionBounds)) {
            setClipToCompositionBounds(typedArrayObtainStyledAttributes.getBoolean(f0.LottieAnimationView_lottie_clipToCompositionBounds, true));
        }
        if (typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_clipTextToBoundingBox)) {
            setClipTextToBoundingBox(typedArrayObtainStyledAttributes.getBoolean(f0.LottieAnimationView_lottie_clipTextToBoundingBox, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_defaultFontFileExtension)) {
            setDefaultFontFileExtension(typedArrayObtainStyledAttributes.getString(f0.LottieAnimationView_lottie_defaultFontFileExtension));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(f0.LottieAnimationView_lottie_imageAssetsFolder));
        boolean zHasValue4 = typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_progress);
        float f = typedArrayObtainStyledAttributes.getFloat(f0.LottieAnimationView_lottie_progress, 0.0f);
        if (zHasValue4) {
            hashSet.add(h.f7850v);
        }
        wVar.s(f);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(f0.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        if (wVar.F != z2) {
            wVar.F = z2;
            if (wVar.f7918u != null) {
                wVar.c();
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_colorFilter)) {
            wVar.a(new q5.e("**"), z.F, new c(new h0(f0.c.c(getContext(), typedArrayObtainStyledAttributes.getResourceId(f0.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor(), PorterDuff.Mode.SRC_ATOP)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_renderMode)) {
            int i = typedArrayObtainStyledAttributes.getInt(f0.LottieAnimationView_lottie_renderMode, 0);
            setRenderMode(g0.values()[i >= g0.values().length ? 0 : i]);
        }
        if (typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_asyncUpdates)) {
            int i10 = typedArrayObtainStyledAttributes.getInt(f0.LottieAnimationView_lottie_asyncUpdates, 0);
            setAsyncUpdates(a.values()[i10 >= g0.values().length ? 0 : i10]);
        }
        setIgnoreDisabledSystemAnimations(typedArrayObtainStyledAttributes.getBoolean(f0.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        if (typedArrayObtainStyledAttributes.hasValue(f0.LottieAnimationView_lottie_useCompositionFrameRate)) {
            setUseCompositionFrameRate(typedArrayObtainStyledAttributes.getBoolean(f0.LottieAnimationView_lottie_useCompositionFrameRate, false));
        }
        typedArrayObtainStyledAttributes.recycle();
        Context context2 = getContext();
        j jVar = g.f14267a;
        wVar.f7920w = Settings.Global.getFloat(context2.getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f;
    }

    private void setCompositionTask(c0 c0Var) {
        a0 a0Var = c0Var.f7830d;
        w wVar = this.B;
        if (a0Var != null && wVar == getDrawable() && wVar.f7918u == a0Var.f7823a) {
            return;
        }
        this.H.add(h.f7849u);
        this.B.d();
        a();
        c0Var.b(this.f2755x);
        c0Var.a(this.f2756y);
        this.J = c0Var;
    }

    public final void a() {
        c0 c0Var = this.J;
        if (c0Var != null) {
            i iVar = this.f2755x;
            synchronized (c0Var) {
                c0Var.f7827a.remove(iVar);
            }
            this.J.e(this.f2756y);
        }
    }

    public a getAsyncUpdates() {
        a aVar = this.B.f7911d0;
        return aVar != null ? aVar : a.f7820u;
    }

    public boolean getAsyncUpdatesEnabled() {
        a aVar = this.B.f7911d0;
        if (aVar == null) {
            aVar = a.f7820u;
        }
        return aVar == a.f7821v;
    }

    public boolean getClipTextToBoundingBox() {
        return this.B.N;
    }

    public boolean getClipToCompositionBounds() {
        return this.B.H;
    }

    public l5.j getComposition() {
        Drawable drawable = getDrawable();
        w wVar = this.B;
        if (drawable == wVar) {
            return wVar.f7918u;
        }
        return null;
    }

    public long getDuration() {
        l5.j composition = getComposition();
        if (composition != null) {
            return (long) composition.b();
        }
        return 0L;
    }

    public int getFrame() {
        return (int) this.B.f7919v.B;
    }

    public String getImageAssetsFolder() {
        return this.B.B;
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.B.G;
    }

    public float getMaxFrame() {
        return this.B.f7919v.b();
    }

    public float getMinFrame() {
        return this.B.f7919v.c();
    }

    public d0 getPerformanceTracker() {
        l5.j jVar = this.B.f7918u;
        if (jVar != null) {
            return jVar.f7857a;
        }
        return null;
    }

    public float getProgress() {
        return this.B.f7919v.a();
    }

    public g0 getRenderMode() {
        return this.B.P ? g0.f7847w : g0.f7846v;
    }

    public int getRepeatCount() {
        return this.B.f7919v.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.B.f7919v.getRepeatMode();
    }

    public float getSpeed() {
        return this.B.f7919v.f14262x;
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if (drawable instanceof w) {
            boolean z2 = ((w) drawable).P;
            g0 g0Var = g0.f7847w;
            if ((z2 ? g0Var : g0.f7846v) == g0Var) {
                this.B.invalidateSelf();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        w wVar = this.B;
        if (drawable2 == wVar) {
            super.invalidateDrawable(wVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.F) {
            return;
        }
        this.B.j();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof l5.g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        l5.g gVar = (l5.g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        this.C = gVar.f7839u;
        HashSet hashSet = this.H;
        h hVar = h.f7849u;
        if (!hashSet.contains(hVar) && !TextUtils.isEmpty(this.C)) {
            setAnimation(this.C);
        }
        this.D = gVar.f7840v;
        if (!hashSet.contains(hVar) && (i = this.D) != 0) {
            setAnimation(i);
        }
        boolean zContains = hashSet.contains(h.f7850v);
        w wVar = this.B;
        if (!zContains) {
            wVar.s(gVar.f7841w);
        }
        h hVar2 = h.f7854z;
        if (!hashSet.contains(hVar2) && gVar.f7842x) {
            hashSet.add(hVar2);
            wVar.j();
        }
        if (!hashSet.contains(h.f7853y)) {
            setImageAssetsFolder(gVar.f7843y);
        }
        if (!hashSet.contains(h.f7851w)) {
            setRepeatMode(gVar.f7844z);
        }
        if (hashSet.contains(h.f7852x)) {
            return;
        }
        setRepeatCount(gVar.A);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z2;
        l5.g gVar = new l5.g(super.onSaveInstanceState());
        gVar.f7839u = this.C;
        gVar.f7840v = this.D;
        w wVar = this.B;
        d dVar = wVar.f7919v;
        d dVar2 = wVar.f7919v;
        gVar.f7841w = dVar.a();
        if (wVar.isVisible()) {
            z2 = dVar2.G;
        } else {
            int i = wVar.f7917j0;
            z2 = i == 2 || i == 3;
        }
        gVar.f7842x = z2;
        gVar.f7843y = wVar.B;
        gVar.f7844z = dVar2.getRepeatMode();
        gVar.A = dVar2.getRepeatCount();
        return gVar;
    }

    public void setAnimation(final int i) {
        c0 c0VarA;
        this.D = i;
        final String str = null;
        this.C = null;
        if (isInEditMode()) {
            c0VarA = new c0(new Callable() { // from class: l5.f
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieAnimationView lottieAnimationView = this.f7837a;
                    boolean z2 = lottieAnimationView.G;
                    int i10 = i;
                    if (!z2) {
                        return n.e(i10, lottieAnimationView.getContext(), null);
                    }
                    Context context = lottieAnimationView.getContext();
                    return n.e(i10, context, n.j(context, i10));
                }
            }, true);
        } else if (this.G) {
            Context context = getContext();
            final String strJ = n.j(context, i);
            final WeakReference weakReference = new WeakReference(context);
            final Context applicationContext = context.getApplicationContext();
            c0VarA = n.a(strJ, new Callable() { // from class: l5.m
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = (Context) weakReference.get();
                    if (context2 == null) {
                        context2 = applicationContext;
                    }
                    return n.e(i, context2, strJ);
                }
            }, null);
        } else {
            Context context2 = getContext();
            HashMap map = n.f7882a;
            final WeakReference weakReference2 = new WeakReference(context2);
            final Context applicationContext2 = context2.getApplicationContext();
            c0VarA = n.a(null, new Callable() { // from class: l5.m
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context22 = (Context) weakReference2.get();
                    if (context22 == null) {
                        context22 = applicationContext2;
                    }
                    return n.e(i, context22, str);
                }
            }, null);
        }
        setCompositionTask(c0VarA);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        setCompositionTask(n.a(null, new bb.d(1, byteArrayInputStream), new a2.a(26, byteArrayInputStream)));
    }

    public void setAnimationFromUrl(String str) {
        c0 c0VarA;
        int i = 0;
        Object obj = null;
        if (this.G) {
            Context context = getContext();
            HashMap map = n.f7882a;
            String strM = l4.a.m("url_", str);
            c0VarA = n.a(strM, new k(context, str, strM, i), null);
        } else {
            c0VarA = n.a(null, new k(getContext(), str, obj, i), null);
        }
        setCompositionTask(c0VarA);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z2) {
        this.B.M = z2;
    }

    public void setAsyncUpdates(a aVar) {
        this.B.f7911d0 = aVar;
    }

    public void setCacheComposition(boolean z2) {
        this.G = z2;
    }

    public void setClipTextToBoundingBox(boolean z2) {
        w wVar = this.B;
        if (z2 != wVar.N) {
            wVar.N = z2;
            wVar.invalidateSelf();
        }
    }

    public void setClipToCompositionBounds(boolean z2) {
        w wVar = this.B;
        if (z2 != wVar.H) {
            wVar.H = z2;
            t5.c cVar = wVar.I;
            if (cVar != null) {
                cVar.I = z2;
            }
            wVar.invalidateSelf();
        }
    }

    public void setComposition(l5.j jVar) {
        w wVar = this.B;
        wVar.setCallback(this);
        boolean z2 = true;
        this.E = true;
        ArrayList arrayList = wVar.f7923z;
        d dVar = wVar.f7919v;
        if (wVar.f7918u == jVar) {
            z2 = false;
        } else {
            wVar.f7910c0 = true;
            wVar.d();
            wVar.f7918u = jVar;
            wVar.c();
            boolean z10 = dVar.F == null;
            dVar.F = jVar;
            if (z10) {
                dVar.i(Math.max(dVar.D, jVar.f7866l), Math.min(dVar.E, jVar.f7867m));
            } else {
                dVar.i((int) jVar.f7866l, (int) jVar.f7867m);
            }
            float f = dVar.B;
            dVar.B = 0.0f;
            dVar.A = 0.0f;
            dVar.h((int) f);
            dVar.f();
            wVar.s(dVar.getAnimatedFraction());
            Iterator it = new ArrayList(arrayList).iterator();
            while (it.hasNext()) {
                v vVar = (v) it.next();
                if (vVar != null) {
                    vVar.run();
                }
                it.remove();
            }
            arrayList.clear();
            jVar.f7857a.f7834a = wVar.K;
            wVar.e();
            Drawable.Callback callback = wVar.getCallback();
            if (callback instanceof ImageView) {
                ImageView imageView = (ImageView) callback;
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(wVar);
            }
        }
        if (this.F) {
            wVar.j();
        }
        this.E = false;
        if (getDrawable() != wVar || z2) {
            if (!z2) {
                boolean z11 = dVar != null ? dVar.G : false;
                setImageDrawable(null);
                setImageDrawable(wVar);
                if (z11) {
                    wVar.l();
                }
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator it2 = this.I.iterator();
            if (it2.hasNext()) {
                throw l4.a.k(it2);
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        w wVar = this.B;
        wVar.E = str;
        zc.c cVarH = wVar.h();
        if (cVarH != null) {
            cVarH.f14949y = str;
        }
    }

    public void setFailureListener(l5.y yVar) {
        this.f2757z = yVar;
    }

    public void setFallbackResource(int i) {
        this.A = i;
    }

    public void setFontAssetDelegate(b bVar) {
        zc.c cVar = this.B.C;
    }

    public void setFontMap(Map<String, Typeface> map) {
        w wVar = this.B;
        if (map == wVar.D) {
            return;
        }
        wVar.D = map;
        wVar.invalidateSelf();
    }

    public void setFrame(int i) {
        this.B.m(i);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z2) {
        this.B.f7921x = z2;
    }

    public void setImageAssetDelegate(l5.c cVar) {
        p5.a aVar = this.B.A;
    }

    public void setImageAssetsFolder(String str) {
        this.B.B = str;
    }

    @Override // n.y, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.D = 0;
        this.C = null;
        a();
        super.setImageBitmap(bitmap);
    }

    @Override // n.y, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.D = 0;
        this.C = null;
        a();
        super.setImageDrawable(drawable);
    }

    @Override // n.y, android.widget.ImageView
    public void setImageResource(int i) {
        this.D = 0;
        this.C = null;
        a();
        super.setImageResource(i);
    }

    public void setMaintainOriginalImageBounds(boolean z2) {
        this.B.G = z2;
    }

    public void setMaxFrame(int i) {
        this.B.n(i);
    }

    public void setMaxProgress(float f) {
        w wVar = this.B;
        l5.j jVar = wVar.f7918u;
        if (jVar == null) {
            wVar.f7923z.add(new r(wVar, f, 0));
            return;
        }
        d dVar = wVar.f7919v;
        dVar.i(dVar.D, f.e(jVar.f7866l, jVar.f7867m, f));
    }

    public void setMinAndMaxFrame(String str) {
        this.B.p(str);
    }

    public void setMinFrame(int i) {
        this.B.q(i);
    }

    public void setMinProgress(float f) {
        w wVar = this.B;
        l5.j jVar = wVar.f7918u;
        if (jVar == null) {
            wVar.f7923z.add(new r(wVar, f, 1));
        } else {
            wVar.q((int) f.e(jVar.f7866l, jVar.f7867m, f));
        }
    }

    public void setOutlineMasksAndMattes(boolean z2) {
        w wVar = this.B;
        if (wVar.L == z2) {
            return;
        }
        wVar.L = z2;
        t5.c cVar = wVar.I;
        if (cVar != null) {
            cVar.r(z2);
        }
    }

    public void setPerformanceTrackingEnabled(boolean z2) {
        w wVar = this.B;
        wVar.K = z2;
        l5.j jVar = wVar.f7918u;
        if (jVar != null) {
            jVar.f7857a.f7834a = z2;
        }
    }

    public void setProgress(float f) {
        this.H.add(h.f7850v);
        this.B.s(f);
    }

    public void setRenderMode(g0 g0Var) {
        w wVar = this.B;
        wVar.O = g0Var;
        wVar.e();
    }

    public void setRepeatCount(int i) {
        this.H.add(h.f7852x);
        this.B.f7919v.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.H.add(h.f7851w);
        this.B.f7919v.setRepeatMode(i);
    }

    public void setSafeMode(boolean z2) {
        this.B.f7922y = z2;
    }

    public void setSpeed(float f) {
        this.B.f7919v.f14262x = f;
    }

    public void setTextDelegate(i0 i0Var) {
        this.B.getClass();
    }

    public void setUseCompositionFrameRate(boolean z2) {
        this.B.f7919v.H = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void unscheduleDrawable(android.graphics.drawable.Drawable r5) {
        /*
            r4 = this;
            boolean r0 = r4.E
            r1 = 0
            if (r0 != 0) goto L19
            l5.w r2 = r4.B
            if (r5 != r2) goto L19
            x5.d r3 = r2.f7919v
            if (r3 != 0) goto Lf
            r3 = r1
            goto L11
        Lf:
            boolean r3 = r3.G
        L11:
            if (r3 == 0) goto L19
            r4.F = r1
            r2.i()
            goto L2e
        L19:
            if (r0 != 0) goto L2e
            boolean r0 = r5 instanceof l5.w
            if (r0 == 0) goto L2e
            r0 = r5
            l5.w r0 = (l5.w) r0
            x5.d r2 = r0.f7919v
            if (r2 != 0) goto L27
            goto L29
        L27:
            boolean r1 = r2.G
        L29:
            if (r1 == 0) goto L2e
            r0.i()
        L2e:
            super.unscheduleDrawable(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.unscheduleDrawable(android.graphics.drawable.Drawable):void");
    }

    public void setMaxFrame(String str) {
        this.B.o(str);
    }

    public void setMinFrame(String str) {
        this.B.r(str);
    }

    public void setAnimation(String str) {
        c0 c0VarA;
        this.C = str;
        int i = 0;
        this.D = 0;
        int i10 = 1;
        if (isInEditMode()) {
            c0VarA = new c0(new l5.d(this, i, str), true);
        } else {
            Object obj = null;
            if (this.G) {
                Context context = getContext();
                HashMap map = n.f7882a;
                String strM = l4.a.m("asset_", str);
                c0VarA = n.a(strM, new k(context.getApplicationContext(), str, strM, i10), null);
            } else {
                Context context2 = getContext();
                HashMap map2 = n.f7882a;
                c0VarA = n.a(null, new k(context2.getApplicationContext(), str, obj, i10), null);
            }
        }
        setCompositionTask(c0VarA);
    }
}
