package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import g6.a;
import g6.a0;
import g6.b0;
import g6.d;
import g6.d0;
import g6.e0;
import g6.f;
import g6.f0;
import g6.g;
import g6.g0;
import g6.h;
import g6.h0;
import g6.i;
import g6.i0;
import g6.j;
import g6.j0;
import g6.k;
import g6.n;
import g6.r;
import g6.v;
import g6.x;
import g6.z;
import i0.c;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import l6.e;
import o.w;
import o6.b;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends w {
    public static final d L = new d();
    public z A;
    public int B;
    public final g6.w C;
    public String D;
    public int E;
    public boolean F;
    public boolean G;
    public boolean H;
    public final HashSet I;
    public final HashSet J;
    public d0 K;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final h f2190y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final h f2191z;

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        String string;
        super(context, attributeSet, 0);
        this.f2190y = new h(this, 1);
        this.f2191z = new h(this, 0);
        this.B = 0;
        g6.w wVar = new g6.w();
        this.C = wVar;
        this.F = false;
        this.G = false;
        this.H = true;
        HashSet hashSet = new HashSet();
        this.I = hashSet;
        this.J = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, g0.LottieAnimationView, f0.lottieAnimationViewStyle, 0);
        this.H = typedArrayObtainStyledAttributes.getBoolean(g0.LottieAnimationView_lottie_cacheComposition, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_rawRes);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_fileName);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_url);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(g0.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(g0.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(g0.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(g0.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(g0.LottieAnimationView_lottie_autoPlay, false)) {
            this.G = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(g0.LottieAnimationView_lottie_loop, false)) {
            wVar.f5153w.setRepeatCount(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(g0.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(g0.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(g0.LottieAnimationView_lottie_speed, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_clipToCompositionBounds)) {
            setClipToCompositionBounds(typedArrayObtainStyledAttributes.getBoolean(g0.LottieAnimationView_lottie_clipToCompositionBounds, true));
        }
        if (typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_clipTextToBoundingBox)) {
            setClipTextToBoundingBox(typedArrayObtainStyledAttributes.getBoolean(g0.LottieAnimationView_lottie_clipTextToBoundingBox, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_defaultFontFileExtension)) {
            setDefaultFontFileExtension(typedArrayObtainStyledAttributes.getString(g0.LottieAnimationView_lottie_defaultFontFileExtension));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(g0.LottieAnimationView_lottie_imageAssetsFolder));
        boolean zHasValue4 = typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_progress);
        float f = typedArrayObtainStyledAttributes.getFloat(g0.LottieAnimationView_lottie_progress, 0.0f);
        if (zHasValue4) {
            hashSet.add(g.f5076w);
        }
        wVar.u(f);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(g0.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        HashSet hashSet2 = (HashSet) wVar.G.f10035w;
        x xVar = x.f5157v;
        boolean zAdd = z10 ? hashSet2.add(xVar) : hashSet2.remove(xVar);
        if (wVar.f5152v != null && zAdd) {
            wVar.c();
        }
        setApplyingOpacityToLayersEnabled(typedArrayObtainStyledAttributes.getBoolean(g0.LottieAnimationView_lottie_applyOpacityToLayers, false));
        setApplyingShadowToLayersEnabled(typedArrayObtainStyledAttributes.getBoolean(g0.LottieAnimationView_lottie_applyShadowToLayers, true));
        if (typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_colorFilter)) {
            wVar.a(new e("**"), a0.I, new nb.w(new i0(c.c(getContext(), typedArrayObtainStyledAttributes.getResourceId(g0.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor(), PorterDuff.Mode.SRC_ATOP)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_renderMode)) {
            int i = typedArrayObtainStyledAttributes.getInt(g0.LottieAnimationView_lottie_renderMode, 0);
            setRenderMode(h0.values()[i >= h0.values().length ? 0 : i]);
        }
        if (typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_asyncUpdates)) {
            int i10 = typedArrayObtainStyledAttributes.getInt(g0.LottieAnimationView_lottie_asyncUpdates, 0);
            setAsyncUpdates(a.values()[i10 >= h0.values().length ? 0 : i10]);
        }
        setIgnoreDisabledSystemAnimations(typedArrayObtainStyledAttributes.getBoolean(g0.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        if (typedArrayObtainStyledAttributes.hasValue(g0.LottieAnimationView_lottie_useCompositionFrameRate)) {
            setUseCompositionFrameRate(typedArrayObtainStyledAttributes.getBoolean(g0.LottieAnimationView_lottie_useCompositionFrameRate, false));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void setCompositionTask(d0 d0Var) {
        b0 b0Var = d0Var.f5064d;
        g6.w wVar = this.C;
        if (b0Var != null && wVar == getDrawable() && wVar.f5152v == b0Var.f5057a) {
            return;
        }
        this.I.add(g.f5075v);
        this.C.d();
        a();
        d0Var.b(this.f2190y);
        d0Var.a(this.f2191z);
        this.K = d0Var;
    }

    public final void a() {
        d0 d0Var = this.K;
        if (d0Var != null) {
            h hVar = this.f2190y;
            synchronized (d0Var) {
                d0Var.f5061a.remove(hVar);
            }
            this.K.e(this.f2191z);
        }
    }

    public a getAsyncUpdates() {
        a aVar = this.C.f5145g0;
        return aVar != null ? aVar : a.f5030v;
    }

    public boolean getAsyncUpdatesEnabled() {
        a aVar = this.C.f5145g0;
        if (aVar == null) {
            aVar = a.f5030v;
        }
        return aVar == a.f5031w;
    }

    public boolean getClipTextToBoundingBox() {
        return this.C.P;
    }

    public boolean getClipToCompositionBounds() {
        return this.C.I;
    }

    public i getComposition() {
        Drawable drawable = getDrawable();
        g6.w wVar = this.C;
        if (drawable == wVar) {
            return wVar.f5152v;
        }
        return null;
    }

    public long getDuration() {
        i composition = getComposition();
        if (composition != null) {
            return (long) composition.b();
        }
        return 0L;
    }

    public int getFrame() {
        return (int) this.C.f5153w.C;
    }

    public String getImageAssetsFolder() {
        return this.C.C;
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.C.H;
    }

    public float getMaxFrame() {
        return this.C.f5153w.b();
    }

    public float getMinFrame() {
        return this.C.f5153w.c();
    }

    public e0 getPerformanceTracker() {
        i iVar = this.C.f5152v;
        if (iVar != null) {
            return iVar.f5086a;
        }
        return null;
    }

    public float getProgress() {
        return this.C.f5153w.a();
    }

    public h0 getRenderMode() {
        return this.C.R ? h0.f5084x : h0.f5083w;
    }

    public int getRepeatCount() {
        return this.C.f5153w.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.C.f5153w.getRepeatMode();
    }

    public float getSpeed() {
        return this.C.f5153w.f11555y;
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if (drawable instanceof g6.w) {
            boolean z10 = ((g6.w) drawable).R;
            h0 h0Var = h0.f5084x;
            if ((z10 ? h0Var : h0.f5083w) == h0Var) {
                this.C.invalidateSelf();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        g6.w wVar = this.C;
        if (drawable2 == wVar) {
            super.invalidateDrawable(wVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.G) {
            return;
        }
        this.C.l();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        this.D = fVar.f5070v;
        HashSet hashSet = this.I;
        g gVar = g.f5075v;
        if (!hashSet.contains(gVar) && !TextUtils.isEmpty(this.D)) {
            setAnimation(this.D);
        }
        this.E = fVar.f5071w;
        if (!hashSet.contains(gVar) && (i = this.E) != 0) {
            setAnimation(i);
        }
        boolean zContains = hashSet.contains(g.f5076w);
        g6.w wVar = this.C;
        if (!zContains) {
            wVar.u(fVar.f5072x);
        }
        g gVar2 = g.A;
        if (!hashSet.contains(gVar2) && fVar.f5073y) {
            hashSet.add(gVar2);
            wVar.l();
        }
        if (!hashSet.contains(g.f5079z)) {
            setImageAssetsFolder(fVar.f5074z);
        }
        if (!hashSet.contains(g.f5077x)) {
            setRepeatMode(fVar.A);
        }
        if (hashSet.contains(g.f5078y)) {
            return;
        }
        setRepeatCount(fVar.B);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z10;
        f fVar = new f(super.onSaveInstanceState());
        fVar.f5070v = this.D;
        fVar.f5071w = this.E;
        g6.w wVar = this.C;
        s6.e eVar = wVar.f5153w;
        s6.e eVar2 = wVar.f5153w;
        fVar.f5072x = eVar.a();
        if (wVar.isVisible()) {
            z10 = eVar2.H;
        } else {
            int i = wVar.f5151m0;
            z10 = i == 2 || i == 3;
        }
        fVar.f5073y = z10;
        fVar.f5074z = wVar.C;
        fVar.A = eVar2.getRepeatMode();
        fVar.B = eVar2.getRepeatCount();
        return fVar;
    }

    public void setAnimation(final int i) {
        d0 d0VarA;
        this.E = i;
        final String str = null;
        this.D = null;
        if (isInEditMode()) {
            d0VarA = new d0(new Callable() { // from class: g6.e
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    LottieAnimationView lottieAnimationView = this.f5065a;
                    boolean z10 = lottieAnimationView.H;
                    int i10 = i;
                    if (!z10) {
                        return n.f(i10, lottieAnimationView.getContext(), null);
                    }
                    Context context = lottieAnimationView.getContext();
                    return n.f(i10, context, n.k(context, i10));
                }
            }, true);
        } else if (this.H) {
            Context context = getContext();
            final String strK = n.k(context, i);
            final WeakReference weakReference = new WeakReference(context);
            final Context applicationContext = context.getApplicationContext();
            d0VarA = n.a(strK, new Callable() { // from class: g6.m
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = (Context) weakReference.get();
                    if (context2 == null) {
                        context2 = applicationContext;
                    }
                    return n.f(i, context2, strK);
                }
            }, null);
        } else {
            Context context2 = getContext();
            HashMap map = n.f5113a;
            final WeakReference weakReference2 = new WeakReference(context2);
            final Context applicationContext2 = context2.getApplicationContext();
            d0VarA = n.a(null, new Callable() { // from class: g6.m
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context22 = (Context) weakReference2.get();
                    if (context22 == null) {
                        context22 = applicationContext2;
                    }
                    return n.f(i, context22, str);
                }
            }, null);
        }
        setCompositionTask(d0VarA);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        setCompositionTask(n.a(null, new k(0, byteArrayInputStream), new androidx.emoji2.text.w(11, byteArrayInputStream)));
    }

    public void setAnimationFromUrl(String str) {
        d0 d0VarA;
        int i = 0;
        Object obj = null;
        if (this.H) {
            Context context = getContext();
            HashMap map = n.f5113a;
            String strN = q4.a.n("url_", str);
            d0VarA = n.a(strN, new j(context, str, strN, i), null);
        } else {
            d0VarA = n.a(null, new j(getContext(), str, obj, i), null);
        }
        setCompositionTask(d0VarA);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z10) {
        this.C.N = z10;
    }

    public void setApplyingShadowToLayersEnabled(boolean z10) {
        this.C.O = z10;
    }

    public void setAsyncUpdates(a aVar) {
        this.C.f5145g0 = aVar;
    }

    public void setCacheComposition(boolean z10) {
        this.H = z10;
    }

    public void setClipTextToBoundingBox(boolean z10) {
        g6.w wVar = this.C;
        if (z10 != wVar.P) {
            wVar.P = z10;
            wVar.invalidateSelf();
        }
    }

    public void setClipToCompositionBounds(boolean z10) {
        g6.w wVar = this.C;
        if (z10 != wVar.I) {
            wVar.I = z10;
            b bVar = wVar.J;
            if (bVar != null) {
                bVar.L = z10;
            }
            wVar.invalidateSelf();
        }
    }

    public void setComposition(i iVar) {
        g6.w wVar = this.C;
        wVar.setCallback(this);
        boolean z10 = true;
        this.F = true;
        ArrayList arrayList = wVar.A;
        s6.e eVar = wVar.f5153w;
        if (wVar.f5152v == iVar) {
            z10 = false;
        } else {
            wVar.f5144f0 = true;
            wVar.d();
            wVar.f5152v = iVar;
            wVar.c();
            boolean z11 = eVar.G == null;
            eVar.G = iVar;
            if (z11) {
                eVar.i(Math.max(eVar.E, iVar.f5095l), Math.min(eVar.F, iVar.f5096m));
            } else {
                eVar.i((int) iVar.f5095l, (int) iVar.f5096m);
            }
            float f = eVar.C;
            eVar.C = 0.0f;
            eVar.B = 0.0f;
            eVar.h((int) f);
            eVar.f();
            wVar.u(eVar.getAnimatedFraction());
            Iterator it = new ArrayList(arrayList).iterator();
            while (it.hasNext()) {
                v vVar = (v) it.next();
                if (vVar != null) {
                    vVar.run();
                }
                it.remove();
            }
            arrayList.clear();
            iVar.f5086a.f5067a = wVar.L;
            wVar.e();
            Drawable.Callback callback = wVar.getCallback();
            if (callback instanceof ImageView) {
                ImageView imageView = (ImageView) callback;
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(wVar);
            }
        }
        if (this.G) {
            wVar.l();
        }
        this.F = false;
        if (getDrawable() != wVar || z10) {
            if (!z10) {
                boolean z12 = eVar != null ? eVar.H : false;
                setImageDrawable(null);
                setImageDrawable(wVar);
                if (z12) {
                    wVar.n();
                }
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator it2 = this.J.iterator();
            if (it2.hasNext()) {
                throw q4.a.l(it2);
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        g6.w wVar = this.C;
        wVar.F = str;
        dd.c cVarI = wVar.i();
        if (cVarI != null) {
            cVarI.A = str;
        }
    }

    public void setFailureListener(z zVar) {
        this.A = zVar;
    }

    public void setFallbackResource(int i) {
        this.B = i;
    }

    public void setFontAssetDelegate(g6.b bVar) {
        dd.c cVar = this.C.D;
    }

    public void setFontMap(Map<String, Typeface> map) {
        g6.w wVar = this.C;
        if (map == wVar.E) {
            return;
        }
        wVar.E = map;
        wVar.invalidateSelf();
    }

    public void setFrame(int i) {
        this.C.o(i);
    }

    @Deprecated
    public void setIgnoreDisabledSystemAnimations(boolean z10) {
        this.C.f5155y = z10;
    }

    public void setImageAssetDelegate(g6.c cVar) {
        k6.a aVar = this.C.B;
    }

    public void setImageAssetsFolder(String str) {
        this.C.C = str;
    }

    @Override // o.w, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.E = 0;
        this.D = null;
        a();
        super.setImageBitmap(bitmap);
    }

    @Override // o.w, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.E = 0;
        this.D = null;
        a();
        super.setImageDrawable(drawable);
    }

    @Override // o.w, android.widget.ImageView
    public void setImageResource(int i) {
        this.E = 0;
        this.D = null;
        a();
        super.setImageResource(i);
    }

    public void setMaintainOriginalImageBounds(boolean z10) {
        this.C.H = z10;
    }

    public void setMaxFrame(int i) {
        this.C.p(i);
    }

    public void setMaxProgress(float f) {
        g6.w wVar = this.C;
        i iVar = wVar.f5152v;
        if (iVar == null) {
            wVar.A.add(new r(wVar, f, 0));
            return;
        }
        s6.e eVar = wVar.f5153w;
        eVar.i(eVar.E, s6.g.f(iVar.f5095l, iVar.f5096m, f));
    }

    public void setMinAndMaxFrame(String str) {
        this.C.r(str);
    }

    public void setMinFrame(int i) {
        this.C.s(i);
    }

    public void setMinProgress(float f) {
        g6.w wVar = this.C;
        i iVar = wVar.f5152v;
        if (iVar == null) {
            wVar.A.add(new r(wVar, f, 1));
        } else {
            wVar.s((int) s6.g.f(iVar.f5095l, iVar.f5096m, f));
        }
    }

    public void setOutlineMasksAndMattes(boolean z10) {
        g6.w wVar = this.C;
        if (wVar.M == z10) {
            return;
        }
        wVar.M = z10;
        b bVar = wVar.J;
        if (bVar != null) {
            bVar.q(z10);
        }
    }

    public void setPerformanceTrackingEnabled(boolean z10) {
        g6.w wVar = this.C;
        wVar.L = z10;
        i iVar = wVar.f5152v;
        if (iVar != null) {
            iVar.f5086a.f5067a = z10;
        }
    }

    public void setProgress(float f) {
        this.I.add(g.f5076w);
        this.C.u(f);
    }

    public void setRenderMode(h0 h0Var) {
        g6.w wVar = this.C;
        wVar.Q = h0Var;
        wVar.e();
    }

    public void setRepeatCount(int i) {
        this.I.add(g.f5078y);
        this.C.f5153w.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.I.add(g.f5077x);
        this.C.f5153w.setRepeatMode(i);
    }

    public void setSafeMode(boolean z10) {
        this.C.f5156z = z10;
    }

    public void setSpeed(float f) {
        this.C.f5153w.f11555y = f;
    }

    public void setTextDelegate(j0 j0Var) {
        this.C.getClass();
    }

    public void setUseCompositionFrameRate(boolean z10) {
        this.C.f5153w.I = z10;
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
            boolean r0 = r4.F
            r1 = 0
            if (r0 != 0) goto L19
            g6.w r2 = r4.C
            if (r5 != r2) goto L19
            s6.e r3 = r2.f5153w
            if (r3 != 0) goto Lf
            r3 = r1
            goto L11
        Lf:
            boolean r3 = r3.H
        L11:
            if (r3 == 0) goto L19
            r4.G = r1
            r2.k()
            goto L2e
        L19:
            if (r0 != 0) goto L2e
            boolean r0 = r5 instanceof g6.w
            if (r0 == 0) goto L2e
            r0 = r5
            g6.w r0 = (g6.w) r0
            s6.e r2 = r0.f5153w
            if (r2 != 0) goto L27
            goto L29
        L27:
            boolean r1 = r2.H
        L29:
            if (r1 == 0) goto L2e
            r0.k()
        L2e:
            super.unscheduleDrawable(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.unscheduleDrawable(android.graphics.drawable.Drawable):void");
    }

    public void setMaxFrame(String str) {
        this.C.q(str);
    }

    public void setMinFrame(String str) {
        this.C.t(str);
    }

    public void setAnimation(String str) {
        d0 d0VarA;
        this.D = str;
        this.E = 0;
        int i = 1;
        if (isInEditMode()) {
            d0VarA = new d0(new b2.j(2, this, str), true);
        } else {
            Object obj = null;
            if (this.H) {
                Context context = getContext();
                HashMap map = n.f5113a;
                String strN = q4.a.n("asset_", str);
                d0VarA = n.a(strN, new j(context.getApplicationContext(), str, strN, i), null);
            } else {
                Context context2 = getContext();
                HashMap map2 = n.f5113a;
                d0VarA = n.a(null, new j(context2.getApplicationContext(), str, obj, i), null);
            }
        }
        setCompositionTask(d0VarA);
    }
}
