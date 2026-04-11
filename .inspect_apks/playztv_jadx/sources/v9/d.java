package v9;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends n {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13345e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f13346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f13347h;
    public EditText i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.google.android.material.datepicker.n f13348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f13349k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnimatorSet f13350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f13351m;

    public d(m mVar) {
        super(mVar);
        this.f13348j = new com.google.android.material.datepicker.n(12, this);
        this.f13349k = new a(this, 0);
        this.f13345e = b8.h.x(mVar.getContext(), p8.b.motionDurationShort3, 100);
        this.f = b8.h.x(mVar.getContext(), p8.b.motionDurationShort3, 150);
        this.f13346g = b8.h.y(mVar.getContext(), p8.b.motionEasingLinearInterpolator, q8.a.f11072a);
        this.f13347h = b8.h.y(mVar.getContext(), p8.b.motionEasingEmphasizedInterpolator, q8.a.f11075d);
    }

    @Override // v9.n
    public final void a() {
        if (this.f13377b.J != null) {
            return;
        }
        s(t());
    }

    @Override // v9.n
    public final int c() {
        return p8.j.clear_text_end_icon_content_description;
    }

    @Override // v9.n
    public final int d() {
        return p8.e.mtrl_ic_cancel;
    }

    @Override // v9.n
    public final View.OnFocusChangeListener e() {
        return this.f13349k;
    }

    @Override // v9.n
    public final View.OnClickListener f() {
        return this.f13348j;
    }

    @Override // v9.n
    public final View.OnFocusChangeListener g() {
        return this.f13349k;
    }

    @Override // v9.n
    public final void l(EditText editText) {
        this.i = editText;
        this.f13376a.setEndIconVisible(t());
    }

    @Override // v9.n
    public final void o(boolean z2) {
        if (this.f13377b.J == null) {
            return;
        }
        s(z2);
    }

    @Override // v9.n
    public final void q() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f13347h);
        valueAnimatorOfFloat.setDuration(this.f);
        final int i = 1;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: v9.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f13342b;

            {
                this.f13342b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        d dVar = this.f13342b;
                        dVar.getClass();
                        dVar.f13379d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        d dVar2 = this.f13342b;
                        dVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = dVar2.f13379d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f13346g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i10 = this.f13345e;
        valueAnimatorOfFloat2.setDuration(i10);
        final int i11 = 0;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: v9.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f13342b;

            {
                this.f13342b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        d dVar = this.f13342b;
                        dVar.getClass();
                        dVar.f13379d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        d dVar2 = this.f13342b;
                        dVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = dVar2.f13379d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f13350l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f13350l.addListener(new c(this, i11));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i10);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: v9.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f13342b;

            {
                this.f13342b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i11) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        d dVar = this.f13342b;
                        dVar.getClass();
                        dVar.f13379d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        d dVar2 = this.f13342b;
                        dVar2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = dVar2.f13379d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        this.f13351m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new c(this, i));
    }

    @Override // v9.n
    public final void r() {
        EditText editText = this.i;
        if (editText != null) {
            editText.post(new nc.b(11, this));
        }
    }

    public final void s(boolean z2) {
        boolean z10 = this.f13377b.d() == z2;
        if (z2 && !this.f13350l.isRunning()) {
            this.f13351m.cancel();
            this.f13350l.start();
            if (z10) {
                this.f13350l.end();
                return;
            }
            return;
        }
        if (z2) {
            return;
        }
        this.f13350l.cancel();
        this.f13351m.start();
        if (z10) {
            this.f13351m.end();
        }
    }

    public final boolean t() {
        EditText editText = this.i;
        if (editText != null) {
            return (editText.hasFocus() || this.f13379d.hasFocus()) && this.i.getText().length() > 0;
        }
        return false;
    }
}
