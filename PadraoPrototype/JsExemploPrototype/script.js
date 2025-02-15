function Personagem(nome, nivel) {
    this.nome = nome;
    this.nivel = nivel;
}

Personagem.prototype.atacar = function () {
    return `${this.nome} ataca com um golpe básico!`;
};

function Guerreiro(nome, nivel, arma) {
    Personagem.call(this, nome, nivel);
    this.arma = arma;
}

Guerreiro.prototype = Object.create(Personagem.prototype);
Guerreiro.prototype.constructor = Guerreiro;

Guerreiro.prototype.atacar = function () {
    return `${this.nome} ataca com ${this.arma}!`;
};

function Mago(nome, nivel, elemento) {
    Personagem.call(this, nome, nivel);
    this.elemento = elemento;
}

Mago.prototype = Object.create(Personagem.prototype);
Mago.prototype.constructor = Mago;

Mago.prototype.atacar = function () {
    return `${this.nome} lança um feitiço de ${this.elemento}!`;
};

function testarHeranca() {
    const personagemBase = new Personagem("Aventureiro", 1);
    const guerreiro = new Guerreiro("Thor", 5, "Martelo");
    const mago = new Mago("Merlin", 10, "fogo");

    const resultado = `
        <p>${personagemBase.atacar()}</p>
        <p>${guerreiro.atacar()}</p>
        <p>${mago.atacar()}</p>
    `;

    document.getElementById("resultado").innerHTML = resultado;
}
