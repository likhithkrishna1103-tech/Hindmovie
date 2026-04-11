package androidx.media3.ui;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m4.b;
import m4.c;
import m4.q0;
import m4.w0;
import w1.d;
import x1.a;
import x1.f;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class SubtitleView extends FrameLayout {
    public boolean A;
    public int B;
    public q0 C;
    public View D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List f1310v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f1311w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f1312x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f1313y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1314z;

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1310v = Collections.EMPTY_LIST;
        this.f1311w = c.f8162g;
        this.f1312x = 0.0533f;
        this.f1313y = 0.08f;
        this.f1314z = true;
        this.A = true;
        b bVar = new b(context, 0);
        this.C = bVar;
        this.D = bVar;
        addView(bVar);
        this.B = 1;
    }

    private List<x1.b> getCuesWithStylingPreferencesApplied() {
        if (this.f1314z && this.A) {
            return this.f1310v;
        }
        ArrayList arrayList = new ArrayList(this.f1310v.size());
        for (int i = 0; i < this.f1310v.size(); i++) {
            a aVarA = ((x1.b) this.f1310v.get(i)).a();
            if (!this.f1314z) {
                aVarA.f14236n = false;
                CharSequence charSequence = aVarA.f14225a;
                if (charSequence instanceof Spanned) {
                    if (!(charSequence instanceof Spannable)) {
                        aVarA.f14225a = SpannableString.valueOf(charSequence);
                        aVarA.f14226b = null;
                    }
                    CharSequence charSequence2 = aVarA.f14225a;
                    charSequence2.getClass();
                    Spannable spannable = (Spannable) charSequence2;
                    for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                        if (!(obj instanceof f)) {
                            spannable.removeSpan(obj);
                        }
                    }
                }
                d.s(aVarA);
            } else if (!this.A) {
                d.s(aVarA);
            }
            arrayList.add(aVarA.a());
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (a0.f14551a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private c getUserCaptionStyle() {
        CaptioningManager captioningManager;
        int i = a0.f14551a;
        c cVar = c.f8162g;
        if (i < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return cVar;
        }
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        if (i >= 21) {
            return new c(userStyle.hasForegroundColor() ? userStyle.foregroundColor : -1, userStyle.hasBackgroundColor() ? userStyle.backgroundColor : -16777216, userStyle.hasWindowColor() ? userStyle.windowColor : 0, userStyle.hasEdgeType() ? userStyle.edgeType : 0, userStyle.hasEdgeColor() ? userStyle.edgeColor : -1, userStyle.getTypeface());
        }
        return new c(userStyle.foregroundColor, userStyle.backgroundColor, 0, userStyle.edgeType, userStyle.edgeColor, userStyle.getTypeface());
    }

    private <T extends View & q0> void setView(T t10) {
        removeView(this.D);
        View view = this.D;
        if (view instanceof w0) {
            ((w0) view).f8295w.destroy();
        }
        this.D = t10;
        this.C = t10;
        addView(t10);
    }

    public final void a() {
        setStyle(getUserCaptionStyle());
    }

    public final void b() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void c() {
        this.C.a(getCuesWithStylingPreferencesApplied(), this.f1311w, this.f1312x, this.f1313y);
    }

    public void setApplyEmbeddedFontSizes(boolean z10) {
        this.A = z10;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z10) {
        this.f1314z = z10;
        c();
    }

    public void setBottomPaddingFraction(float f) {
        this.f1313y = f;
        c();
    }

    public void setCues(List<x1.b> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.f1310v = list;
        c();
    }

    public void setFractionalTextSize(float f) {
        this.f1312x = f;
        c();
    }

    public void setStyle(c cVar) {
        this.f1311w = cVar;
        c();
    }

    public void setViewType(int i) {
        if (this.B == i) {
            return;
        }
        if (i == 1) {
            setView(new b(getContext(), 0));
        } else {
            if (i != 2) {
                throw new IllegalArgumentException();
            }
            setView(new w0(getContext()));
        }
        this.B = i;
    }
}
