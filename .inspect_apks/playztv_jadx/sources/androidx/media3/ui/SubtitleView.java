package androidx.media3.ui;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import i4.b;
import i4.c;
import i4.t0;
import i4.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import r1.a;
import r1.f;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class SubtitleView extends FrameLayout {
    public int A;
    public t0 B;
    public View C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List f1617u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f1618v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f1619w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f1620x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1621y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1622z;

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1617u = Collections.EMPTY_LIST;
        this.f1618v = c.f6212g;
        this.f1619w = 0.0533f;
        this.f1620x = 0.08f;
        this.f1621y = true;
        this.f1622z = true;
        b bVar = new b(context, 0);
        this.B = bVar;
        this.C = bVar;
        addView(bVar);
        this.A = 1;
    }

    private List<r1.b> getCuesWithStylingPreferencesApplied() {
        if (this.f1621y && this.f1622z) {
            return this.f1617u;
        }
        ArrayList arrayList = new ArrayList(this.f1617u.size());
        for (int i = 0; i < this.f1617u.size(); i++) {
            a aVarA = ((r1.b) this.f1617u.get(i)).a();
            if (!this.f1621y) {
                aVarA.f11240n = false;
                CharSequence charSequence = aVarA.f11229a;
                if (charSequence instanceof Spanned) {
                    if (!(charSequence instanceof Spannable)) {
                        aVarA.f11229a = SpannableString.valueOf(charSequence);
                        aVarA.f11230b = null;
                    }
                    CharSequence charSequence2 = aVarA.f11229a;
                    charSequence2.getClass();
                    Spannable spannable = (Spannable) charSequence2;
                    for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                        if (!(obj instanceof f)) {
                            spannable.removeSpan(obj);
                        }
                    }
                }
                z7.a.x(aVarA);
            } else if (!this.f1622z) {
                z7.a.x(aVarA);
            }
            arrayList.add(aVarA.a());
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (b0.f11647a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private c getUserCaptionStyle() {
        CaptioningManager captioningManager;
        int i = b0.f11647a;
        c cVar = c.f6212g;
        if (i < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return cVar;
        }
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        if (i >= 21) {
            return new c(userStyle.hasForegroundColor() ? userStyle.foregroundColor : -1, userStyle.hasBackgroundColor() ? userStyle.backgroundColor : -16777216, userStyle.hasWindowColor() ? userStyle.windowColor : 0, userStyle.hasEdgeType() ? userStyle.edgeType : 0, userStyle.hasEdgeColor() ? userStyle.edgeColor : -1, userStyle.getTypeface());
        }
        return new c(userStyle.foregroundColor, userStyle.backgroundColor, 0, userStyle.edgeType, userStyle.edgeColor, userStyle.getTypeface());
    }

    private <T extends View & t0> void setView(T t10) {
        removeView(this.C);
        View view = this.C;
        if (view instanceof z0) {
            ((z0) view).f6354v.destroy();
        }
        this.C = t10;
        this.B = t10;
        addView(t10);
    }

    public final void a() {
        setStyle(getUserCaptionStyle());
    }

    public final void b() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void c() {
        this.B.a(getCuesWithStylingPreferencesApplied(), this.f1618v, this.f1619w, this.f1620x);
    }

    public void setApplyEmbeddedFontSizes(boolean z2) {
        this.f1622z = z2;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z2) {
        this.f1621y = z2;
        c();
    }

    public void setBottomPaddingFraction(float f) {
        this.f1620x = f;
        c();
    }

    public void setCues(List<r1.b> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.f1617u = list;
        c();
    }

    public void setFractionalTextSize(float f) {
        this.f1619w = f;
        c();
    }

    public void setStyle(c cVar) {
        this.f1618v = cVar;
        c();
    }

    public void setViewType(int i) {
        if (this.A == i) {
            return;
        }
        if (i == 1) {
            setView(new b(getContext(), 0));
        } else {
            if (i != 2) {
                throw new IllegalArgumentException();
            }
            setView(new z0(getContext()));
        }
        this.A = i;
    }
}
