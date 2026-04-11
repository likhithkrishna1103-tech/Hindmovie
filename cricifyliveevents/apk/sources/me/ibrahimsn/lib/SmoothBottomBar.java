package me.ibrahimsn.lib;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import fe.l;
import ge.i;
import hf.a;
import hf.b;
import hf.c;
import hf.d;
import hf.e;
import hf.f;
import hf.g;
import hf.h;
import hf.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k0.k;
import sd.p;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class SmoothBottomBar extends View {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ int f8469c0 = 0;
    public int A;
    public int B;
    public float C;
    public float D;
    public float E;
    public int F;
    public float G;
    public long H;
    public float I;
    public float J;
    public int K;
    public int L;
    public int M;
    public float N;
    public int O;
    public int P;
    public int Q;
    public d R;
    public c S;
    public l T;
    public l U;
    public final Paint V;
    public final Paint W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final Paint f8470a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final a f8471b0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f8472v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8473w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f8474x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f8475y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f8476z;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object, java.util.List] */
    public SmoothBottomBar(Context context, AttributeSet attributeSet) throws Throwable {
        Throwable th;
        int i = e.SmoothBottomBarStyle;
        i.e(context, "context");
        super(context, attributeSet, i);
        this.f8473w = getItemIconTintActive();
        this.f8474x = getBarSideMargins();
        this.f8475y = new RectF();
        this.f8476z = p.f11669v;
        this.A = -1;
        this.B = Color.parseColor("#2DFFFFFF");
        this.C = w1.d.e(context, 20.0f);
        this.D = w1.d.e(context, 10.0f);
        this.E = w1.d.e(context, 0.0f);
        this.F = 3;
        this.G = w1.d.e(context, 10.0f);
        this.H = 200L;
        this.I = w1.d.e(context, 18.0f);
        this.J = w1.d.e(context, 4.0f);
        this.K = Color.parseColor("#C8FFFFFF");
        this.L = -1;
        this.M = -1;
        this.N = w1.d.e(context, 11.0f);
        this.O = -1;
        this.P = -1;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setColor(getBarIndicatorColor());
        this.V = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(style);
        paint2.setColor(getBarIndicatorColor());
        this.W = paint2;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setStyle(style);
        paint3.setColor(getItemTextColor());
        paint3.setTextSize(getItemTextSize());
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setFakeBoldText(true);
        this.f8470a0 = paint3;
        Context context2 = getContext();
        i.d(context2, "context");
        TypedArray typedArrayObtainStyledAttributes = context2.getTheme().obtainStyledAttributes(attributeSet, g.SmoothBottomBar, i, 0);
        try {
            setBarBackgroundColor(typedArrayObtainStyledAttributes.getColor(g.SmoothBottomBar_backgroundColor, getBarBackgroundColor()));
            setBarIndicatorColor(typedArrayObtainStyledAttributes.getColor(g.SmoothBottomBar_indicatorColor, getBarIndicatorColor()));
            setBarIndicatorRadius(typedArrayObtainStyledAttributes.getDimension(g.SmoothBottomBar_indicatorRadius, getBarIndicatorRadius()));
            setBarSideMargins(typedArrayObtainStyledAttributes.getDimension(g.SmoothBottomBar_sideMargins, getBarSideMargins()));
            setBarCornerRadius(typedArrayObtainStyledAttributes.getDimension(g.SmoothBottomBar_cornerRadius, getBarCornerRadius()));
            setBarCorners(typedArrayObtainStyledAttributes.getInteger(g.SmoothBottomBar_corners, getBarCorners()));
            setItemPadding(typedArrayObtainStyledAttributes.getDimension(g.SmoothBottomBar_itemPadding, getItemPadding()));
            setItemTextColor(typedArrayObtainStyledAttributes.getColor(g.SmoothBottomBar_textColor, getItemTextColor()));
            setItemTextSize(typedArrayObtainStyledAttributes.getDimension(g.SmoothBottomBar_textSize, getItemTextSize()));
            setItemIconSize(typedArrayObtainStyledAttributes.getDimension(g.SmoothBottomBar_iconSize, getItemIconSize()));
            setItemIconMargin(typedArrayObtainStyledAttributes.getDimension(g.SmoothBottomBar_iconMargin, getItemIconMargin()));
            setItemIconTint(typedArrayObtainStyledAttributes.getColor(g.SmoothBottomBar_iconTint, getItemIconTint()));
            setItemIconTintActive(typedArrayObtainStyledAttributes.getColor(g.SmoothBottomBar_iconTintActive, getItemIconTintActive()));
            setItemActiveIndex(typedArrayObtainStyledAttributes.getInt(g.SmoothBottomBar_activeItem, getItemActiveIndex()));
            setItemFontFamily(typedArrayObtainStyledAttributes.getResourceId(g.SmoothBottomBar_itemFontFamily, getItemFontFamily()));
            setItemAnimDuration(typedArrayObtainStyledAttributes.getInt(g.SmoothBottomBar_duration, (int) getItemAnimDuration()));
            setItemMenuRes(typedArrayObtainStyledAttributes.getResourceId(g.SmoothBottomBar_menu, getItemMenuRes()));
        } catch (Exception e9) {
            try {
                e9.printStackTrace();
            } catch (Throwable th2) {
                th = th2;
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        a aVar = new a(this, this.f8476z, new h(1, this, SmoothBottomBar.class, "onClickAction", "onClickAction(I)V", 0, 0, 0));
        this.f8471b0 = aVar;
        m0.n(this, aVar);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, java.util.List] */
    public final void a() {
        if (this.f8476z.isEmpty()) {
            return;
        }
        int i = 0;
        for (b bVar : this.f8476z) {
            if (i == getItemActiveIndex()) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(bVar.f5963e, 255);
                valueAnimatorOfInt.setDuration(getItemAnimDuration());
                valueAnimatorOfInt.addUpdateListener(new hf.i(this, bVar));
                valueAnimatorOfInt.start();
            } else {
                ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(bVar.f5963e, 0);
                valueAnimatorOfInt2.setDuration(getItemAnimDuration());
                valueAnimatorOfInt2.addUpdateListener(new hf.i(this, bVar));
                valueAnimatorOfInt2.start();
            }
            i++;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f8474x, ((b) this.f8476z.get(getItemActiveIndex())).f5962d.left);
        valueAnimatorOfFloat.setDuration(getItemAnimDuration());
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new j(this, 0));
        valueAnimatorOfFloat.start();
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(getItemIconTint()), Integer.valueOf(getItemIconTintActive()));
        valueAnimatorOfObject.setDuration(getItemAnimDuration());
        valueAnimatorOfObject.addUpdateListener(new j(this, 1));
        valueAnimatorOfObject.start();
    }

    public final void b(int i) {
        ViewParent parent;
        a aVar = this.f8471b0;
        View view = aVar.i;
        if (i != Integer.MIN_VALUE && aVar.f1639h.isEnabled() && (parent = view.getParent()) != null) {
            AccessibilityEvent accessibilityEventK = aVar.k(i, 2048);
            accessibilityEventK.setContentChangeTypes(0);
            parent.requestSendAccessibilityEvent(view, accessibilityEventK);
        }
        if (i != getItemActiveIndex()) {
            setItemActiveIndex(i);
            l lVar = this.T;
            if (lVar != null) {
            }
            d dVar = this.R;
            if (dVar != null) {
                dVar.d(i);
            }
        } else {
            l lVar2 = this.U;
            if (lVar2 != null) {
            }
            c cVar = this.S;
            if (cVar != null) {
                ((l) ((pc.c) cVar).f10180v).a(Integer.valueOf(i));
            }
        }
        aVar.w(i, 1);
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        i.e(motionEvent, "event");
        return this.f8471b0.m(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public final int getBarBackgroundColor() {
        return this.A;
    }

    public final float getBarCornerRadius() {
        return this.E;
    }

    public final int getBarCorners() {
        return this.F;
    }

    public final int getBarIndicatorColor() {
        return this.B;
    }

    public final float getBarIndicatorRadius() {
        return this.C;
    }

    public final float getBarSideMargins() {
        return this.D;
    }

    public final int getItemActiveIndex() {
        return this.Q;
    }

    public final long getItemAnimDuration() {
        return this.H;
    }

    public final int getItemFontFamily() {
        return this.O;
    }

    public final float getItemIconMargin() {
        return this.J;
    }

    public final float getItemIconSize() {
        return this.I;
    }

    public final int getItemIconTint() {
        return this.K;
    }

    public final int getItemIconTintActive() {
        return this.L;
    }

    public final int getItemMenuRes() {
        return this.P;
    }

    public final float getItemPadding() {
        return this.G;
    }

    public final int getItemTextColor() {
        return this.M;
    }

    public final float getItemTextSize() {
        return this.N;
    }

    public final l getOnItemReselected() {
        return this.U;
    }

    public final c getOnItemReselectedListener() {
        return this.S;
    }

    public final l getOnItemSelected() {
        return this.T;
    }

    public final d getOnItemSelectedListener() {
        return this.R;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00d5  */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Iterable, java.lang.Object] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r19) {
        /*
            Method dump skipped, instruction units count: 708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: me.ibrahimsn.lib.SmoothBottomBar.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Iterable, java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, java.util.List] */
    @Override // android.view.View
    public final void onSizeChanged(int i, int i10, int i11, int i12) {
        ?? R0;
        super.onSizeChanged(i, i10, i11, i12);
        float barSideMargins = getBarSideMargins();
        float f = 2;
        this.f8472v = (getWidth() - (getBarSideMargins() * f)) / this.f8476z.size();
        if (getLayoutDirection() == 1) {
            ?? r72 = this.f8476z;
            i.e(r72, "<this>");
            if (r72.size() <= 1) {
                R0 = sd.j.r0(r72);
            } else {
                List listT0 = sd.j.t0(r72);
                Collections.reverse(listT0);
                R0 = listT0;
            }
        } else {
            R0 = this.f8476z;
        }
        for (b bVar : R0) {
            boolean z10 = false;
            while (this.f8470a0.measureText(bVar.f5959a) > ((this.f8472v - getItemIconSize()) - getItemIconMargin()) - (getItemPadding() * f)) {
                bVar.f5959a = ne.h.e0(bVar.f5959a);
                z10 = true;
            }
            if (z10) {
                String strE0 = ne.h.e0(bVar.f5959a);
                bVar.f5959a = strE0;
                StringBuilder sbB = y.e.b(strE0);
                sbB.append(getContext().getString(f.ellipsis));
                String string = sbB.toString();
                i.e(string, "<set-?>");
                bVar.f5959a = string;
            }
            bVar.f5962d = new RectF(barSideMargins, 0.0f, this.f8472v + barSideMargins, getHeight());
            barSideMargins += this.f8472v;
        }
        a();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Iterable, java.lang.Object] */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Integer numValueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == 1) {
            Iterator it = this.f8476z.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((b) it.next()).f5962d.contains(motionEvent.getX(), motionEvent.getY())) {
                    b(i);
                    break;
                }
                i++;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setBarBackgroundColor(int i) {
        this.A = i;
        this.V.setColor(i);
        invalidate();
    }

    public final void setBarCornerRadius(float f) {
        this.E = f;
        invalidate();
    }

    public final void setBarCorners(int i) {
        this.F = i;
        invalidate();
    }

    public final void setBarIndicatorColor(int i) {
        this.B = i;
        this.W.setColor(i);
        invalidate();
    }

    public final void setBarIndicatorRadius(float f) {
        this.C = f;
        invalidate();
    }

    public final void setBarSideMargins(float f) {
        this.D = f;
        invalidate();
    }

    public final void setItemActiveIndex(int i) {
        this.Q = i;
        a();
    }

    public final void setItemAnimDuration(long j4) {
        this.H = j4;
    }

    public final void setItemFontFamily(int i) {
        this.O = i;
        if (i != -1) {
            Context context = getContext();
            ThreadLocal threadLocal = k.f6774a;
            this.f8470a0.setTypeface(context.isRestricted() ? null : k.b(context, i, new TypedValue(), 0, null, false, false));
            invalidate();
        }
    }

    public final void setItemIconMargin(float f) {
        this.J = f;
        invalidate();
    }

    public final void setItemIconSize(float f) {
        this.I = f;
        invalidate();
    }

    public final void setItemIconTint(int i) {
        this.K = i;
        invalidate();
    }

    public final void setItemIconTintActive(int i) {
        this.L = i;
        invalidate();
    }

    public final void setItemMenuRes(int i) throws Throwable {
        int next;
        this.P = i;
        if (i != -1) {
            Context context = getContext();
            i.d(context, "context");
            XmlResourceParser xml = context.getResources().getXml(i);
            i.d(xml, "context.resources.getXml(res)");
            ArrayList arrayList = new ArrayList();
            do {
                next = xml.next();
                if (next == 2 && i.a(xml.getName(), "item")) {
                    int attributeCount = xml.getAttributeCount();
                    Drawable drawable = null;
                    String attributeValue = null;
                    String strValueOf = null;
                    for (int i10 = 0; i10 < attributeCount; i10++) {
                        String attributeName = xml.getAttributeName(i10);
                        if (attributeName != null) {
                            int iHashCode = attributeName.hashCode();
                            if (iHashCode != -1273585213) {
                                if (iHashCode != 3226745) {
                                    if (iHashCode == 110371416 && attributeName.equals("title")) {
                                        try {
                                            attributeValue = context.getString(xml.getAttributeResourceValue(i10, 0));
                                        } catch (Resources.NotFoundException unused) {
                                            attributeValue = xml.getAttributeValue(i10);
                                        }
                                    }
                                } else if (attributeName.equals("icon")) {
                                    drawable = context.getDrawable(xml.getAttributeResourceValue(i10, 0));
                                }
                            } else if (attributeName.equals("contentDescription")) {
                                try {
                                    strValueOf = context.getString(xml.getAttributeResourceValue(i10, 0));
                                } catch (Resources.NotFoundException unused2) {
                                    strValueOf = xml.getAttributeValue(i10);
                                }
                            }
                        }
                    }
                    if (drawable == null) {
                        throw new Throwable("Item icon can not be null!");
                    }
                    String strValueOf2 = String.valueOf(attributeValue);
                    if (strValueOf == null) {
                        strValueOf = String.valueOf(attributeValue);
                    }
                    arrayList.add(new b(strValueOf2, strValueOf, drawable));
                }
            } while (next != 1);
            this.f8476z = arrayList;
            invalidate();
        }
    }

    public final void setItemPadding(float f) {
        this.G = f;
        invalidate();
    }

    public final void setItemTextColor(int i) {
        this.M = i;
        this.f8470a0.setColor(i);
        invalidate();
    }

    public final void setItemTextSize(float f) {
        this.N = f;
        this.f8470a0.setTextSize(f);
        invalidate();
    }

    public final void setOnItemReselected(l lVar) {
        this.U = lVar;
    }

    public final void setOnItemReselectedListener(c cVar) {
        this.S = cVar;
    }

    public final void setOnItemSelected(l lVar) {
        this.T = lVar;
    }

    public final void setOnItemSelectedListener(d dVar) {
        this.R = dVar;
    }

    public final void setOnItemReselectedListener(l lVar) {
        i.e(lVar, "listener");
        this.S = new pc.c(lVar);
    }

    public final void setOnItemSelectedListener(l lVar) {
        i.e(lVar, "listener");
        this.R = new e1.a(lVar);
    }
}
