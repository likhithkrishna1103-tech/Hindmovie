package o;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f9416d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9417a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f9418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f9419c;

    public /* synthetic */ z() {
    }

    public KeyListener a(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((i2.k) ((p6.d) this.f9419c).f10037w).getClass();
        if (keyListener instanceof m1.e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new m1.e(keyListener);
    }

    public void b(AttributeSet attributeSet, int i) {
        switch (this.f9417a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.f9418b;
                l7.a aVarF = l7.a.F(absSeekBar.getContext(), attributeSet, f9416d, i);
                Drawable drawableV = aVarF.v(0);
                if (drawableV != null) {
                    if (drawableV instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawableV;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i10 = 0; i10 < numberOfFrames; i10++) {
                            Drawable drawableE = e(animationDrawable.getFrame(i10), true);
                            drawableE.setLevel(10000);
                            animationDrawable2.addFrame(drawableE, animationDrawable.getDuration(i10));
                        }
                        animationDrawable2.setLevel(10000);
                        drawableV = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(drawableV);
                }
                Drawable drawableV2 = aVarF.v(1);
                if (drawableV2 != null) {
                    absSeekBar.setProgressDrawable(e(drawableV2, false));
                }
                aVarF.G();
                return;
            default:
                TypedArray typedArrayObtainStyledAttributes = ((EditText) this.f9418b).getContext().obtainStyledAttributes(attributeSet, g.j.AppCompatTextView, i, 0);
                try {
                    boolean z10 = true;
                    if (typedArrayObtainStyledAttributes.hasValue(g.j.AppCompatTextView_emojiCompatEnabled)) {
                        z10 = typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTextView_emojiCompatEnabled, true);
                        break;
                    }
                    typedArrayObtainStyledAttributes.recycle();
                    d(z10);
                    return;
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public m1.b c(InputConnection inputConnection, EditorInfo editorInfo) {
        p6.d dVar = (p6.d) this.f9419c;
        if (inputConnection == null) {
            dVar.getClass();
            inputConnection = null;
        } else {
            i2.k kVar = (i2.k) dVar.f10037w;
            kVar.getClass();
            if (!(inputConnection instanceof m1.b)) {
                inputConnection = new m1.b((EditText) kVar.f6085v, inputConnection, editorInfo);
            }
        }
        return (m1.b) inputConnection;
    }

    public void d(boolean z10) {
        m1.i iVar = (m1.i) ((i2.k) ((p6.d) this.f9419c).f10037w).f6086w;
        if (iVar.f8036x != z10) {
            if (iVar.f8035w != null) {
                androidx.emoji2.text.m mVarA = androidx.emoji2.text.m.a();
                m1.h hVar = iVar.f8035w;
                mVarA.getClass();
                com.bumptech.glide.f.f(hVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = mVarA.f864a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    mVarA.f865b.remove(hVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            iVar.f8036x = z10;
            if (z10) {
                m1.i.a(iVar.f8034v, androidx.emoji2.text.m.a().b());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable e(Drawable drawable, boolean z10) {
        if (drawable instanceof m0.b) {
            ((m0.c) ((m0.b) drawable)).getClass();
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id2 = layerDrawable.getId(i);
                    drawableArr[i] = e(layerDrawable.getDrawable(i), id2 == 16908301 || id2 == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    layerDrawable2.setId(i10, layerDrawable.getId(i10));
                    layerDrawable2.setLayerGravity(i10, layerDrawable.getLayerGravity(i10));
                    layerDrawable2.setLayerWidth(i10, layerDrawable.getLayerWidth(i10));
                    layerDrawable2.setLayerHeight(i10, layerDrawable.getLayerHeight(i10));
                    layerDrawable2.setLayerInsetLeft(i10, layerDrawable.getLayerInsetLeft(i10));
                    layerDrawable2.setLayerInsetRight(i10, layerDrawable.getLayerInsetRight(i10));
                    layerDrawable2.setLayerInsetTop(i10, layerDrawable.getLayerInsetTop(i10));
                    layerDrawable2.setLayerInsetBottom(i10, layerDrawable.getLayerInsetBottom(i10));
                    layerDrawable2.setLayerInsetStart(i10, layerDrawable.getLayerInsetStart(i10));
                    layerDrawable2.setLayerInsetEnd(i10, layerDrawable.getLayerInsetEnd(i10));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.f9419c) == null) {
                    this.f9419c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z10 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public z(AbsSeekBar absSeekBar) {
        this.f9418b = absSeekBar;
    }

    public z(EditText editText) {
        this.f9418b = editText;
        this.f9419c = new p6.d(editText);
    }
}
