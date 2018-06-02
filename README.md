# CodingLife
$$s.t \alpha_1y_1 + \alpha_2y_2 = -\sum\limits_{i=3}^{m} y_i \alpha_i = \varsigma$$
$$ 0 \leq \alpha_i \leq C \qquad i=1,2 $$

$$L(w,b,\alpha) = \frac{1}{2}||w||_2^2 \sum\limits_{i=1}^{m} {\alpha_i {[y_i (w^Tx_i + b) - 1]}} \qquad s.t. \quad \alpha_i \geq 0$$

$$L(w,b,\alpha)=\frac{1}{2}||w||_2^2\sum\limits_{i=1}^{m}\alpha_i[y_i(w^Tx_i+b)-1] \qquad s.t.\quad \alpha_i \geq0$$

$$L(w,b,\alpha)=\frac{1}{2}||w||_2^2 \sum\limits_{i=1}^{m} \alpha_i(y_i (w^Tx_i + b) - 1)\qquad s.t. \quad \alpha_i \geq 0$$ 

$$\underbrace{max}_{\alpha_i \geq 0} \ \underbrace{min}_{w,b} \ L(w,b,\alpha)$$

$${\underbrace{max}_{\alpha_i\geq0}}{\underbrace{min}_{w,b}} \ L(w,b,\alpha)$$

${\underbrace{max}_{\alpha_i\geq0}}{\underbrace{min}_{w,b}} \ L(w,b,\alpha)$

$$\underbrace{max}_{\alpha_i\geq0}\underbrace{min}_{w,b} \ L(w,b,\alpha)$$

求$\underbrace{min}_{w,b} \ L(w,b,\alpha)$对$\alpha$的极大，即是**对偶问题**：

$$\underbrace{min}_{\alpha} \ \frac{1}{2}\sum\limits_{i=1}^{m} \sum\limits_{j=1}^{m}\alpha_i\alpha_j y_i y_j(x_i \bullet x_j)-\sum\limits_{i=1}^{m}\alpha_i$$

$$ s.t. \ \sum\limits_{i=1}^{m}\alpha_iy_i = 0$$

$$ \alpha_i \geq 0  \qquad i=1,2,...m $$

nizhidaoma$\underbrace{min}_{\alpha_1,\alpha_1} \frac{1}{2}K_{11} \alpha_1^2 + \frac{1}{2}K_{22} \alpha_2^2 +y_1y_2K_{12} \alpha_1 \alpha_2 - (\alpha_1+\alpha_2) + y_1 \alpha_1 \sum\limits_{i=3}^{m} y_i \alpha_i K_{i1} + y_2 \alpha_2 \sum\limits_{i=3}^{m} y_i \alpha_i K_{i2}$

$$\underbrace{min}_{\alpha_1,\alpha_1} \frac{1}{2}K_{11} \alpha_1^2 + \frac{1}{2}K_{22} \alpha_2^2 +y_1y_2K_{12} \alpha_1 \alpha_2 - (\alpha_1+\alpha_2) + y_1 \alpha_1 \sum\limits_{i=3}^{m} y_i \alpha_i K_{i1} + y_2 \alpha_2 \sum\limits_{i=3}^{m} y_i \alpha_i K_{i2}$$

$$s.t \alpha_1y_1 + \alpha_2y_2 = -\sum\limits_{i=3}^{m} y_i \alpha_i = \varsigma$$